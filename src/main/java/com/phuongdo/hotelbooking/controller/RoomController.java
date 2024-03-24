package com.phuongdo.hotelbooking.controller;

import com.phuongdo.hotelbooking.model.Room;
import com.phuongdo.hotelbooking.response.RoomResponse;
import com.phuongdo.hotelbooking.service.IRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class RoomController {
    private final IRoomService iRoomService;
    public ResponseEntity<RoomResponse> addNewRoom(
            @RequestParam("photo") MultipartFile photo
            ,@RequestParam("roomType") String roomType
            ,@RequestParam("roomPrice") BigDecimal roomPrice){
        Room savedRoom = iRoomService.addNewRoom(photo,roomType,roomPrice);
        RoomResponse roomResponse = new RoomResponse(savedRoom.getId(),savedRoom.getRoomType(),savedRoom.getRoomPrice());

    }
}
