package com.example.idiom_backend.controller;

import com.example.idiom_backend.bean.IdiomBean;
import com.example.idiom_backend.bean.XingIdiomBean;
import com.example.idiom_backend.bean.YiIdiomBean;
import com.example.idiom_backend.bean.YinIdiomBean;
import com.example.idiom_backend.service.IdiomService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Controller
@ResponseBody
public class IdiomController {

    @Resource
    public IdiomService idiomService;

    @RequestMapping("/")
    public String hello() {
        return "<p>hello</p>";
    }

    @RequestMapping("/findIdiomByName/{name}")
    public IdiomBean findIdiomByName(@PathVariable("name") String name) {
        return idiomService.findIdiomByName(name);
    }

    @RequestMapping("/findIdiomByLikelyName/{name}")
    public List<String> findIdiomByLikelyName(@PathVariable("name") String name) {
        return idiomService.findIdiomByLikelyName(name);
    }

    @RequestMapping("/findIdiomChain/{prefix}")
    public String findIdiomChain(@PathVariable("prefix") String prefix) {
        return idiomService.findIdiomChain(prefix);
    }

    @RequestMapping("/findReverseIdiomChain/{suffix}")
    public String findReverseIdiomChain(@PathVariable("suffix") String suffix) {
        return idiomService.findReverseIdiomChain(suffix);
    }

    @RequestMapping("/getAllIdiom")
    public List<IdiomBean> getAllIdiom() {
        return idiomService.getAllIdiom();
    }

    @RequestMapping("/getOneRandomIdiom")
    public IdiomBean getOneRandomIdiom() {
        return idiomService.getOneRandomIdiom();
    }

    @RequestMapping("/chooseCorrectIdiom")
    public List<String> chooseCorrectIdiom() {
        return idiomService.chooseCorrectIdiom();
    }

    @RequestMapping("/getOneRandomXingIdiom")
    public HashMap getOneRandomXingIdiom() {
        return idiomService.getOneRandomSpecialIdiom(IdiomService.IdiomType.Xing);
    }

    @RequestMapping("/getOneRandomYinIdiom")
    public HashMap getOneRandomYinIdiom() {
        return idiomService.getOneRandomSpecialIdiom(IdiomService.IdiomType.Yin);
    }

    @RequestMapping("/getOneRandomYiIdiom")
    public HashMap getOneRandomYiIdiom() {
        return idiomService.getOneRandomSpecialIdiom(IdiomService.IdiomType.Yi);
    }

}
