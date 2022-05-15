package com.company.domi.controller;

import com.company.domi.dto.LikeDTO;
import com.company.domi.service.LikeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/like")
@Api(tags = "Like Controller")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @PostMapping("/create")
    @ApiOperation(value = "Like")
    public ResponseEntity like(@RequestBody LikeDTO dto) {
        return ResponseEntity.ok(likeService.createLike(dto));
    }


    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleting like")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        likeService.deleteById(id);
        return ResponseEntity.ok("SUCCESS");
    }

}
