/**
 * Created by sathih on 23-09-2016.
 */
public class SpeechDemo {

   /* public static final String API_KEY = "AIzaSyB9-y0wdclhKNmi6nSzuCWGSCEFYmyncS0";
    public static void main(String[] args){
        GSpeechDuplex dup = new GSpeechDuplex(API_KEY);//Instantiate the API
        dup.addResponseListener(new GSpeechResponseListener(){// Adds the listener
            public void onResponse(GoogleResponse gr){
                System.out.println(">>"+gr.getResponse()+"<<");
                System.out.println("Google thinks you said: " + gr.getResponse());
                System.out.println("with " +
                        ((gr.getConfidence()!=null)?(Double.parseDouble(gr.getConfidence())*100):null)
                        + "% confidence.");
                System.out.println("Google also thinks that you might have said:"
                        + gr.getOtherPossibleResponses());
            }
        });
        Microphone mic = new Microphone(FLACFileWriter.FLAC);//Instantiate microphone and have
        // it record FLAC file.
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
    }*/
}
