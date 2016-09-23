package com.hackathon.speechtotext.interpretor;

import com.darkprograms.speech.microphone.Microphone;
import com.darkprograms.speech.recognizer.GSpeechDuplex;
import com.hackathon.speechtotext.listner.AppGSpeechResponseListener;
import javaFlacEncoder.FLACFileWriter;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sathih on 23-09-2016.
 */
public class SpeechToText {
    private static final String API_KEY = "AIzaSyB9-y0wdclhKNmi6nSzuCWGSCEFYmyncS0";

    private GSpeechDuplex dup = null;//Instantiate the API

    private Microphone mic = null;//Instantiate microphone and have

    private SpeechToText(GSpeechDuplex dup, Microphone mic) {
        this.dup = dup;
        this.mic = mic;
    }

    private void captureVoiceRequest() {
        File file = new File("CRAudioTest.flac");//The File to record the buffer to.
        //You can also create your own buffer using the getTargetDataLine() method.
        int count =0;
        while(count<1){
            count++;
            try{
                System.out.println("begin recording");
                mic.captureAudioToFile(file);//Begins recording
                Thread.sleep(8000);//Records for 10 seconds
                mic.close();//Stops recording
                //Sends 10 second voice recording to Google
                byte[] data = Files.readAllBytes(mic.getAudioFile().toPath());//Saves data into memory.
                dup.recognize(data, (int)mic.getAudioFormat().getSampleRate());
                mic.getAudioFile().delete();//Deletes Buffer file
                //REPEAT
            }
            catch(Exception ex){
                ex.printStackTrace();//Prints an error if something goes wrong.
            }
        }
    }

    public static SpeechToText getInstance() {
        GSpeechDuplex dup = new GSpeechDuplex(API_KEY);//Instantiate the API
        Microphone mic = new Microphone(FLACFileWriter.FLAC);//Instantiate microphone and have

        return new SpeechToText(dup, mic);
    }

    public String getRawAppointmentRequest() {
        captureVoiceRequest();

        String rawAppRequestText = "";
        List<String> rawAppRequestList = new ArrayList<String>();
        AppGSpeechResponseListener speechListener = new AppGSpeechResponseListener();
        dup.addResponseListener(speechListener);// Adds the listener
        while(!speechListener.isRecordComplete()) {
            System.out.println("Processing......");
        }
            rawAppRequestText = speechListener.getRawText();
        System.out.println("speechListener = " + rawAppRequestText);
        return rawAppRequestText;
    }


}
