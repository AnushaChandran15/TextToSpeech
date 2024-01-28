package com.anushachandran1502.tts;

import java.util.Locale;
import java.util.Scanner;
import javax.speech.Central;
import javax.speech.EngineException;
import javax.speech.EngineStateError;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.*;


public class TextToSpeech {
	//public static void main(String[] args) {
//		try {
//			// setting properties as Kevin Dictionary
//			System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us" + ".cmu_us_kal.KevinVoiceDirectory");
//			// registering speech engine
//			Central.registerEngineCentral("com.sun.speech.freetts" + ".jsapi.FreeTTSEngineCentral");
//			// create a Synthesizer that generates voice
//			Synthesizer synthesizer = Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));
//			// allocates a synthesizer
//			synthesizer.allocate();
//			// resume a Synthesizer
//			synthesizer.resume();
//			synthesizer.getSynthesizerProperties().setSpeakingRate(120); // Adjust rate
//			synthesizer.getSynthesizerProperties().setPitch(100); // Adjust pitch
//			synthesizer.getSynthesizerProperties().setVolume(100);
//			// speak the specified text until the QUEUE become empty
//			System.out.println("Enter the text to speak:");
//			Scanner sc = new Scanner(System.in);
////	synthesizer.getSynthesizerProperties().setVolume(80);
//			synthesizer.speakPlainText(sc.nextLine(), null);
//			synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
//			// deallocating the Synthesizer
//			synthesizer.deallocate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		
//	}
		private static Synthesizer synthesizer;

	    static {
	        try {
	            System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
	            Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");

	            SynthesizerModeDesc desc = new SynthesizerModeDesc(Locale.US);
	            synthesizer = Central.createSynthesizer(desc);
	            synthesizer.allocate();
	            synthesizer.resume();
	            synthesizer.getSynthesizerProperties().setSpeakingRate(100);
	            synthesizer.getSynthesizerProperties().setPitch(150);
	            synthesizer.getSynthesizerProperties().setVolume(100);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public static void main(String[] args) throws EngineException, EngineStateError {
	        try {
	            Scanner scanner = new Scanner(System.in);

	            while (true) {
	                System.out.println("Enter the text to speak (type 'exit' to stop):");
	                String userInput = scanner.nextLine();

	                if (userInput.equalsIgnoreCase("exit")) {
	                	System.out.println("Exit.......");
	                    break;
	                }

	                doSpeak(userInput);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            synthesizer.deallocate();
	        }
	    }


	    private static void doSpeak(String text) {
	        try {
	            synthesizer.speakPlainText(text, null);
	            synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    
	}
}
