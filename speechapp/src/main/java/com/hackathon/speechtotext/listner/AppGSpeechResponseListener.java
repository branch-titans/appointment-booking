package com.hackathon.speechtotext.listner;

import com.darkprograms.speech.recognizer.GSpeechResponseListener;
import com.darkprograms.speech.recognizer.GoogleResponse;

public class AppGSpeechResponseListener implements GSpeechResponseListener {
	
	private String rawText;
	private boolean recordComplete;

	public void onResponse(GoogleResponse gr) {
		synchronized (this) {
			//rawAppRequestList.
			String rawResponse = gr.getResponse();
			this.rawText = rawResponse.substring(0, rawResponse.indexOf("\""));
			//>>how to get an appointment on Sunday at 10 a.m.","confidence":0.79649955},{"transcript":"set an appointment on Sunday at 10 a.m."},{"transcript":"an appointment on Sunday at 10 a.m."},{"transcript":"how to get an appointment on Sunday at 7 a.m."},{"transcript":"set an appointment on Sunday at 7 a.m.<<

			System.out.println(">>" + gr.getResponse() + "<<");
			System.out.println("Google thinks you said: " + gr.getResponse());
			System.out.println("with " +
					((gr.getConfidence() != null) ? (Double.parseDouble(gr.getConfidence()) * 100) : null)
					+ "% confidence.");
			System.out.println("Google also thinks that you might have said:"
					+ gr.getOtherPossibleResponses());
			recordComplete = true;
		}

	}

	public synchronized boolean isRecordComplete(){
		return recordComplete;
	}
	public String getRawText() {

		return this.rawText;
	}
}
