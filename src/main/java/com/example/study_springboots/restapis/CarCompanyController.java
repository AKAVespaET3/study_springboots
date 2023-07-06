package com.example.study_springboots.restapis;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.study_springboots.service.CarCompanyService;

@RestController
public class CarCompanyController {
    @Autowired
    CarCompanyService carCompanyService;

    // /companyselectSearch/COMPANY/현대자동차
    @GetMapping("/companyselectSearch/{search}/{words}")
    public ResponseEntity selectSearch(@PathVariable String search, @PathVariable String words){
        Object result = carCompanyService.selectSearch(search, words);
        return ResponseEntity.ok().body(result);
        }

    @GetMapping("/companyselectAll/{COMPANY}")
    public ResponseEntity selectAll(@PathVariable String COMPANY){
        Object result = carCompanyService.selectAll(COMPANY);
        return ResponseEntity.ok().body(result);
    }

    // /selectDetail/CI001
    @GetMapping("/companyselectDetail/{COMPANY}")
    public ResponseEntity selectDetail(@PathVariable String COMPANY){
        Object result = carCompanyService.selectDetail(COMPANY);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/companycompanyinsert")
    public ResponseEntity insert(@RequestBody Map paramMap){
        Object result = carCompanyService.insert(paramMap);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/companyupdate")
    public ResponseEntity update(@RequestBody Map paramMap){
        Object result = carCompanyService.update(paramMap);
        return ResponseEntity.ok().body(result);
    }
    @DeleteMapping("/companydelete/{COMPANY}")
    public ResponseEntity delete(@PathVariable String COMPANY){
        Object result = carCompanyService.delete(COMPANY);
        return ResponseEntity.ok().body(result);
    }

     //2PC create
    @PostMapping("/companyinsertDouble")
    public ResponseEntity insertDouble(@RequestBody Map paramMap){
        Object result = null;
        try {
            result =  carCompanyService.insertDouble(paramMap);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(result);
        }
       
        return ResponseEntity.ok().body(result);
}
}
