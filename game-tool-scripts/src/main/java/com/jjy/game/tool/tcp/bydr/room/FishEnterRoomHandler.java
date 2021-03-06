package com.jjy.game.tool.tcp.bydr.room;

import java.util.List;

import com.jzy.game.message.Mid.MID;
import com.jzy.game.message.bydr.BydrFightMessage.FireRequest;
import com.jzy.game.message.bydr.BydrFightMessage.FireResultRequest;
import com.jzy.game.message.bydr.BydrRoomMessage.FishEnterRoomResponse;
import com.jzy.game.message.bydr.BydrRoomMessage.FishInfo;
import com.jzy.game.tool.client.Player;
import com.jzy.game.engine.handler.HandlerEntity;
import com.jzy.game.engine.handler.TcpHandler;
import com.jzy.game.engine.math.MathUtil;

/**
 * 鱼进入房间
 * @author CruiseDing
 * @QQ 359135103
 * 2017年10月20日 上午11:17:49
 */
@HandlerEntity(mid=MID.FishEnterRoomRes_VALUE,msg=FishEnterRoomResponse.class)
public class FishEnterRoomHandler extends TcpHandler {

	public void run() {
		Player player = (Player) session.getAttribute(Player.PLAYER);
		FishEnterRoomResponse res=getMsg();
		List<FishInfo> fishs = res.getFishInfoList();
		
		int random = MathUtil.random(0, res.getFishInfoCount()-1);
		FishInfo fish = fishs.get(random);
		//开炮
		FireRequest.Builder builder=FireRequest.newBuilder();
		builder.setGold(100);
		builder.setTargetFishId(fish.getId(0));
		
		FireResultRequest.Builder resultBuilder=FireResultRequest.newBuilder();
		resultBuilder.addTargetFishId(fish.getId(0));
		resultBuilder.setFireGold(100);
		
		player.sendTcpMsg(builder.build());
		player.sendTcpMsg(resultBuilder.build());
		
	}

}
