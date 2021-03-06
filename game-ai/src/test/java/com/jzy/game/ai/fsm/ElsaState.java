/*******************************************************************************
 * Copyright 2014 See AUTHORS file.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package com.jzy.game.ai.fsm;

import com.jzy.game.ai.msg.MessageManager;
import com.jzy.game.ai.msg.Telegram;
import com.jzy.game.engine.math.MathUtil;
import com.jzy.game.engine.util.TimeUtils;

/** @author davebaol */
public enum ElsaState implements State<Elsa> {

	DO_HOUSE_WORK() {
		@Override
		public void update(Elsa elsa) {
			int r = MathUtil.random(0, 2);
			switch (r) {
			case 0:
				talk(elsa, "Moppin' the floor");
				break;
			case 1:
				talk(elsa, "Washin' the dishes");
				break;
			case 2:
				talk(elsa, "Makin' the bed");
				break;
			}
		}
	},

	VISIT_BATHROOM() {
		@Override
		public void enter(Elsa elsa) {
			talk(elsa, "Walkin' to the can. Need to powda mah pretty li'lle nose");
		}

		@Override
		public void update(Elsa elsa) {
			talk(elsa, "Ahhhhhh! Sweet relief!");
			elsa.getStateMachine().revertToPreviousState();
		}

		@Override
		public void exit(Elsa elsa) {
			talk(elsa, "Leavin' the Jon");
		}
	},

	COOK_STEW() {
		@Override
		public void enter(Elsa elsa) {
			// If not already cooking put the stew in the oven
			if (!elsa.isCooking()) {
				talk(elsa, "Putting the stew in the oven");

				// Send a delayed message myself so that I know when to take the
				// stew out of the oven
				MessageManager.getInstance().dispatchMessage( //
						1, // time delay
						elsa, // sender ID
						elsa, // receiver ID
						MessageType.STEW_READY, // msg
						null);

				elsa.setCooking(true);
			}
		}

		@Override
		public void update(Elsa elsa) {
			talk(elsa, "Fussin' over food");
		}

		@Override
		public void exit(Elsa elsa) {
			talk(elsa, "Puttin' the stew on the table");
		}

		@Override
		public boolean onMessage(Elsa elsa, Telegram telegram) {
			if (telegram.message == MessageType.STEW_READY) {

				talk(elsa, "Message STEW_READY received at time: " + TimeUtils.currentTimeMillis());

				talk(elsa, "StewReady! Lets eat");

				// let hubby know the stew is ready
				MessageManager.getInstance().dispatchMessage( //
						0, // no delay
						elsa, elsa.bob, MessageType.STEW_READY, null);

				elsa.setCooking(false);

				elsa.getStateMachine().changeState(DO_HOUSE_WORK);

				return true;

			}

			return false;
		}
	},

	GLOBAL_STATE() {

		@Override
		public void update(Elsa elsa) {
			// 1 in 10 chance of needing the bathroom (provided she is not already
			// in the bathroom)
			if (MathUtil.randomBoolean(0.1f) && !elsa.getStateMachine().isInState(VISIT_BATHROOM)) {
				elsa.getStateMachine().changeState(VISIT_BATHROOM);
			}
		}

		@Override
		public boolean onMessage(Elsa elsa, Telegram telegram) {

			if (telegram.message == MessageType.HI_HONEY_I_M_HOME) {

				talk(elsa, "Message HI_HONEY_I_M_HOME handled at time: " + TimeUtils.currentTimeMillis());

				talk(elsa, "Hi honey. Let me make you some of mah fine country stew");

				elsa.getStateMachine().changeState(COOK_STEW);

				return true;
			}
			return false;
		}
	};

	@Override
	public void enter(Elsa elsa) {
	}

	@Override
	public void exit(Elsa elsa) {
	}

	@Override
	public boolean onMessage(Elsa elsa, Telegram telegram) {
		return false;
	}

	protected void talk(Elsa elsa, String msg) {
		System.out.println(elsa.getClass().getSimpleName() + " " + msg);
	}

}
