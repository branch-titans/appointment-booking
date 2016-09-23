package com.hackathon.speechtotext.interpretor;

import com.hackathon.speechtotext.keyword.Keyword;
import com.hackathon.speechtotext.keyword.containers.PlaceContainer;
import com.hackathon.speechtotext.keyword.containers.PurposeContainer;
import com.hackathon.speechtotext.keyword.containers.TimeContainer;
import com.hackathon.speechtotext.keyword.containers.WeekDayContainer;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by sathih on 23-09-2016.
 */
public class SpeechTextToKeyword {

    public static final String rawAppointmentString = "book an appointment on Sunday at 10 p.m. in Chennai";
    final List<String> keywords = new ArrayList<>();
    public Keyword collect(){

        final SpeechToText speechToText = SpeechToText.getInstance();
        //final String rawAppointmentString = speechToText.getRawAppointmentRequest();
        StringTokenizer stringTokenizer = new StringTokenizer(rawAppointmentString," ");
        while(stringTokenizer.hasMoreElements()){
            keywords.add((String) stringTokenizer.nextElement());
        }
        final Keyword keyword = buildKeywords(keywords);
        return keyword;
    }

    private Keyword buildKeywords(List<String> keywords) {
        Keyword key = new Keyword();
        for (String keyword : keywords) {
           if(isPurpose(keyword)){
                 key.setPurpose(keyword);
           } else {
               System.out.println("Keyword for PURPOSE not matched");
           }
           if(isPlace(keyword))  {
               key.setPlace(keyword);
           } else {
               System.out.println("Keyword for PLACE not matched");
           }
            if(isTime(keyword))  {
                key.setTime(keyword);
            } else {
                System.out.println("Keyword for TIME not matched");
            }
            if(isWeekday(keyword))  {
                key.setWeekday(keyword);
            } else {
                System.out.println("Keyword for WEEKDAY not matched");
            }
        }
        return key;
    }

    private boolean isWeekday(String keyword) {
        for (WeekDayContainer wkday : WeekDayContainer.values()) {
            if(keyword==wkday.toString()){
                return true;
            }
        }
        return false;

    }

    private boolean isTime(String keyword) {
        for (TimeContainer time : TimeContainer.values()) {
            if(keyword==time.toString()){
                return true;
            }
        }
        return false;
    }

    private boolean isPlace(String keyword) {
        for (PlaceContainer place : PlaceContainer.values()) {
            if(keyword==place.toString()){
                return true;
            }
        }
        return false;
    }

    private boolean isPurpose(String keyword) {
        for (PurposeContainer purpose : PurposeContainer.values()) {
          if(keyword==purpose.toString()){
              return true;
          }
        }
        return false;
    }

    public static void main(String[] args) {
        SpeechTextToKeyword textToKeyword  = new SpeechTextToKeyword();
        final Keyword collect = textToKeyword.collect();
        System.out.println("collect = " + collect);
    }
}
