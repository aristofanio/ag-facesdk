package ag.jna.samples;

import java.util.Arrays;

import Luxand.*; 
import Luxand.FSDK.*; 
import Luxand.FSDKCam.*;

import javax.swing.plaf.metal.sounds.*;

public class App {
	
	public static void main(String[] args) throws InterruptedException {
		//
        try {
            int r = FSDK.ActivateLibrary("kOHyhAx3XZilAdfK4dx3j9UoSJq+vlgWphjGAQrQ1p9xpD4Xn18"
            		+ "SW6P2unPYX18Bmy+5ZlgwVFxks/eMRMNeqk1aMSx7NNaTpTMGCkNTyXDf20del9xHtQ4DD7"
            		+ "FYfDehBRwoUgE2OUAJmpPi+nTvTXJULqKwY8l76KXM2ZQ2Iqg=");
            if (r != FSDK.FSDKE_OK){
               System.out.println("Please run the License Key Wizard (Start - Luxand - FaceSDK - License Key Wizard). " + "Error activating FaceSDK"); 
               System.exit(r);
            }
        } 
        catch(java.lang.UnsatisfiedLinkError e) {
            System.out.println(e.toString());
            System.exit(1);
        }
        
        String[] license = new String[1];
        FSDK.GetLicenseInfo(license);
        System.out.println(Arrays.toString(license));
        
        String[] hardwareID = new String[1];
        FSDK.GetHardware_ID(hardwareID);
        System.out.println(Arrays.toString(hardwareID));
        
        
            
        FSDK.Initialize();
        FSDK.SetFaceDetectionParameters(true, true, 100);
        FSDKCam.SetCameraNaming(true);
        //final HTracker tracker = new HTracker();
        //FSDK.CreateTracker(tracker);

        // set realtime face detection parameters
        //int [] err = new int[1];
        //FSDK.SetTrackerMultipleParameters(tracker, "RecognizeFaces=false; HandleArbitraryRotations=false; DetermineFaceRotationAngle=false; InternalResizeWidth=100; FaceDetectionThreshold=5;", err);
        
        System.out.println(FSDKCam.InitializeCapturing());
                
        TCameras cameraList = new TCameras();
        TCameras cameraPathList = new TCameras();
        //cameraList.cameras = new String[1];
        //cameraPathList.cameras = new String[1];
        int count[] = new int[1];
        System.out.println(FSDKCam.GetCameraListEx(cameraList, cameraPathList, count));
        String cameraName = cameraList.cameras[0];
        
        //
        System.out.println(cameraName);
        //
        FSDKCam.FinalizeCapturing();
	}
	
}
