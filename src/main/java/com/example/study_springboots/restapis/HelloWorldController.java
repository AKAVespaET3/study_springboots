package com.example.study_springboots.restapis;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.study_springboots.service.HelloWorldService;

@Controller // extends HttpServlet을 대신함.
public class HelloWorldController {
    @Autowired  //인스턴스화의 new 기능을 대신 함. IoC와 DI임.
    HelloWorldService helloWorldService;

    @GetMapping("/helloworld")  //@GetMapping을 해주면 public int helloWorld()가 doget이 된다. ("/helloworld")는 @webservlet(urlpattern)을 대신함.
    public int helloWorld(){
        return 0;
    }

    // /helloworldGetRequest?Name=yojulab&Id=U-01 이라고 받던걸
    // /helloworldGetRequest/yojulab/U-01 이라고 받음
    @GetMapping("/helloworldGetRequest/{name}/{Id}")  //메쏘드 이름, url만 다르게 하면 여러개 넣을 수 있음.
    public int helloWorldGetRequest(@PathVariable String name, @PathVariable String Id){
        return 0;
    }

    // ?serviceKey=shXGlOstQIWQOOfPljMPg6P3VUTQ5J24ARIyi6xDOJVfG8EwoL1GT52w3SkPDaqPWaodvM%2BbD8YG0SgKMyVFgw%3D%3D
    // &currentPage=1
    // &perPage=10
    // &SN=1
    // /helloWorldResponse/1/10/1 던질 주소
    @GetMapping("/helloWorldResponse/{currentPage}/{perPage}/{SN}")  //메쏘드 이름, url만 다르게 하면 여러개 넣을 수 있음.
    public ResponseEntity<Object> helloWorldResponse(@PathVariable String currentPage, @PathVariable String perPage, @PathVariable String SN){
        //"spm_row": 471, "SN": 1,"CMPNM": "로이유통","RDNMADR": null
        // Response를 보낼때는 ResponseEntity<Object> 같이 여러가지 클래스? 들이 있음?  Object는 최상위이다.
        HashMap resultmap = new HashMap();
        resultmap.put("spm_row",471);
        resultmap.put("SN",1);
        resultmap.put("CMPNM","로이유통");
        resultmap.put("RDNMADR",null);

        return ResponseEntity.ok().body(resultmap);
    }

        @GetMapping("/helloWorldResponseList/{currentPage}/{perPage}/{SN}")  //메쏘드 이름, url만 다르게 하면 여러개 넣을 수 있음.
        public ResponseEntity<Object> helloWorldResponseList(@PathVariable String currentPage, @PathVariable String perPage, @PathVariable String SN){
        //"spm_row": 471, "SN": 1,"CMPNM": "로이유통","RDNMADR": null
        // "spm_row": 571, "SN": 2, "CMPNM": "의료유통", "RDNMADR": 3
        // Response를 보낼때는 ResponseEntity<Object> 같이 여러가지 클래스? 들이 있음?  Object는 최상위이다.
        ArrayList arrayList = new ArrayList();

        HashMap resultmap = new HashMap();
        resultmap.put("spm_row",471); resultmap.put("SN",1);
        resultmap.put("CMPNM","로이유통"); resultmap.put("RDNMADR",null);
        arrayList.add(resultmap);

        resultmap = new HashMap();
        resultmap.put("spm_row",571); resultmap.put("SN",2);
        resultmap.put("CMPNM","의료유통"); resultmap.put("RDNMADR",3);
        arrayList.add(resultmap);

        return ResponseEntity.ok().body(arrayList);
    }

      @GetMapping("/helloWorldResponseWithService/{currentPage}/{perPage}/{SN}")  //메쏘드 이름, url만 다르게 하면 여러개 넣을 수 있음.
        public ResponseEntity<Object> helloWorldResponseWithService(@PathVariable String currentPage, @PathVariable String perPage, @PathVariable String SN){
            
        ArrayList arrayList = new ArrayList<>();
        arrayList = helloWorldService.fakeSelect(currentPage, perPage);

        return ResponseEntity.ok().body(arrayList);
    }

    @GetMapping("/helloWorldResponseFake/{companyId}")  //메쏘드 이름, url만 다르게 하면 여러개 넣을 수 있음.
    public ResponseEntity<Object> helloWorldResponseFake(@PathVariable String companyId){
            
        ArrayList arrayList = new ArrayList<>();
        helloWorldService.fakeSelect(companyId);

        return ResponseEntity.ok().body(arrayList);
    }
}
