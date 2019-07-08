package com.example.traductor.data_access.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Rol")
public class Rol {

    @DatabaseField(generatedId = true)
    private long id;

    @DatabaseField(canBeNull = false)
    private String name;

    @DatabaseField()
    private int maxParagraphs;

    @DatabaseField()
    private int maxCharsPerParagraph;

    @DatabaseField()
    private boolean english;

    @DatabaseField()
    private boolean spanish;

    @DatabaseField()
    private boolean french;

    public Rol(){}

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxParagraphs() {
        return maxParagraphs;
    }

    public void setMaxParagraphs(int maxParagraphs) {
        this.maxParagraphs = maxParagraphs;
    }

    public int getMaxCharsPerParagraph() {
        return maxCharsPerParagraph;
    }

    public void setMaxCharsPerParagraph(int maxCharsPerParagraph) {
        this.maxCharsPerParagraph = maxCharsPerParagraph;
    }

    public boolean isEnglish() {
        return english;
    }

    public void setEnglish(boolean english) {
        this.english = english;
    }

    public boolean isSpanish() {
        return spanish;
    }

    public void setSpanish(boolean spanish) {
        this.spanish = spanish;
    }

    public boolean isFrench() {
        return french;
    }

    public void setFrench(boolean french) {
        this.french = french;
    }

    @Override
    public String toString(){
        return String.format("Name: %s\tMax P:%d\tMax C:%d\tEng:%b\tSpn:%b\tFrc:%b", name,
                maxParagraphs, maxCharsPerParagraph, english, spanish, french);
    }
}


