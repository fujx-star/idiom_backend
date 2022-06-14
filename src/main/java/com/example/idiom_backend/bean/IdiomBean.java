package com.example.idiom_backend.bean;

public class IdiomBean {
    private String idiom;
    private String pinyin;
    private String meaning;
    private String reference;
    private String example;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    @Override
    public String toString() {
        return "IdiomBean{" +
                "idiom='" + idiom + '\'' +
                ", pinyin='" + pinyin + '\'' +
                ", meaning='" + meaning + '\'' +
                ", reference='" + reference + '\'' +
                ", example='" + example + '\'' +
                '}';
    }

    public IdiomBean(String idiom, String pinyin, String meaning, String reference, String example) {
        this.idiom = idiom;
        this.pinyin = pinyin;
        this.meaning = meaning;
        this.reference = reference;
        this.example = example;
    }

    public String getIdiom() {
        return idiom;
    }

    public void setIdiom(String idiom) {
        this.idiom = idiom;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}
