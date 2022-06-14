package com.example.idiom_backend.service;

import com.example.idiom_backend.bean.IdiomBean;
import com.example.idiom_backend.bean.XingIdiomBean;
import com.example.idiom_backend.bean.YiIdiomBean;
import com.example.idiom_backend.bean.YinIdiomBean;
import com.example.idiom_backend.mapper.IdiomMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class IdiomService {

    @Resource
    private IdiomMapper idiomMapper;

    public IdiomBean findIdiomByName(String name) {
        return idiomMapper.getIdiomByName(name);
    }

    public List<String> findIdiomByLikelyName(String name) {
        return idiomMapper.getIdiomByLikelyName(name);
    }

    public String findIdiomChain(String prefix) {
        char ch = prefix.charAt(0);
        List<String> idioms = idiomMapper.getIdiomByLikelyName(prefix);
        List<String> result = new ArrayList<>();
        for (String idiom : idioms) {
            if (idiom.charAt(0) == ch) {
                result.add(idiom);
            }
        }
        if (result.size() == 0) {
            return null;
        } else {
            return result.get(new Random().nextInt(result.size()));
        }
    }

    public String findReverseIdiomChain(String suffix) {
        char ch = suffix.charAt(0);
        List<String> idioms = idiomMapper.getIdiomByLikelyName(suffix);
        List<String> result = new ArrayList<>();
        for (String idiom : idioms) {
            if (idiom.charAt(idiom.length() - 1) == ch) {
                result.add(idiom);
            }
        }
        if (result.size() == 0) {
            return null;
        } else {
            return result.get(new Random().nextInt(result.size()));
        }
    }

    public IdiomBean getOneRandomIdiom() {
        int count = idiomMapper.getIdiomCount();
        return idiomMapper.getIdiomByIndex(new Random().nextInt(count));
    }

    public List<IdiomBean> getAllIdiom() {
        return idiomMapper.getAllIdiom();
    }

    public List<String> chooseCorrectIdiom() {
        int count = idiomMapper.getIdiomCount();
        HashSet<Integer> indexSet = new HashSet<>();
        Random random = new Random();
        while (indexSet.size() != 13) {
            indexSet.add(random.nextInt(count));
        }
        StringBuilder str = new StringBuilder();
        String correctIdiom = null;
        List<String> list = new ArrayList<>();
        for (Integer index : indexSet) {
            if (correctIdiom == null) {
                correctIdiom = idiomMapper.getIdiomByIndex(index).getIdiom();
            } else {
                String tmpIdiom = idiomMapper.getIdiomByIndex(index).getIdiom();
                str.append(tmpIdiom.charAt(random.nextInt(tmpIdiom.length())));
            }
        }
//        将正确的成语的所有字插入到当前的字符序列中
        for (int i = 0; i < correctIdiom.length(); i++) {
            str.insert(random.nextInt(str.length()), correctIdiom.charAt(i));
        }
        list.add(correctIdiom);
        list.add(str.toString());
        return list;
    }

    public enum IdiomType {
        Xing,Yin,Yi
    }

    public HashMap getOneRandomSpecialIdiom(IdiomType type) {
        List<String> list = new ArrayList<>();
        HashMap hashMap = new HashMap();
        int count;
        switch (type) {
            case Xing -> {
                count = idiomMapper.getXingIdiomCount();
                XingIdiomBean xingIdiom = idiomMapper.getXingIdiomByIndex(new Random().nextInt(count));
                list.add(xingIdiom.getCorrect());
                list.add(xingIdiom.getWrong1());
                list.add(xingIdiom.getWrong2());
                list.add(xingIdiom.getWrong3());
                hashMap.put("idiom", xingIdiom);
            }
            case Yin -> {
                count = idiomMapper.getYinIdiomCount();
                System.out.println(count);
                YinIdiomBean yinIdiom = idiomMapper.getYinIdiomByIndex(new Random().nextInt(count));
                list.add(yinIdiom.getCorrect());
                list.add(yinIdiom.getWrong1());
                list.add(yinIdiom.getWrong2());
                list.add(yinIdiom.getWrong3());
                hashMap.put("idiom", yinIdiom);
            }
            case Yi -> {
                count = idiomMapper.getYiIdiomCount();
                System.out.println(count);
                YiIdiomBean yiIdiom = idiomMapper.getYiIdiomByIndex(new Random().nextInt(count));
                list.add(yiIdiom.getCorrect());
                list.add(yiIdiom.getWrong1());
                list.add(yiIdiom.getWrong2());
                list.add(yiIdiom.getWrong3());
                hashMap.put("idiom", yiIdiom);
            }
            default -> {
            }
        }
        Collections.shuffle(list);
        hashMap.put("content", list);
        return hashMap;
    }

}
