package com.captivators.touristapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import android.widget.TextView;
import android.widget.ImageView;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import org.tensorflow.contrib.android.TensorFlowInferenceInterface;

public class GetPlaceInfo extends AppCompatActivity {

    private TensorFlowInferenceInterface inferenceInterface;
    private static final String MODEL_FILE = "file:///android_asset/tf_model.pb";
    private static final String INPUT_NODE = "conv2d_1_input_1:0";
    private static final String OUTPUT_NODE = "activation_5_1/Softmax:0";
    private static final long[] INPUT_SHAPE = {1,1,128,128};

    // helper function to find the indices of the element in an array with maximum value
    public static int argmax (float [] elems)
    {
        int bestIdx = -1;
        float max = -1000;
        for (int i = 0; i < elems.length; i++) {
            float elem = elems[i];
            if (elem > max) {
                max = elem;
                bestIdx = i;
            }
        }
        return bestIdx;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_place_info);
        inferenceInterface = new TensorFlowInferenceInterface(getAssets(), MODEL_FILE);
        System.out.println("model loaded successfully");

        AssetManager assetManager = getAssets();
        try {
            final int inputSize=128;
            final int destWidth = 128;
            final int destHeight = 128;

            InputStream file = assetManager.open("indiagate.78.jpg");  //tried diff images manually and it works fine
            Bitmap bitmap = BitmapFactory.decodeStream(file);
            Bitmap bitmap_scaled = Bitmap.createScaledBitmap(bitmap, destWidth, destHeight, false);

            // Set the bitmap to the image view
            ImageView image= findViewById(R.id.myImg);
            image.setImageBitmap(bitmap);

            // Load class names of dataset into a string array
            String[] classes = {"hawamahal","indiagate","lotustemple","tajmahal"};

            int[] intValues = new int[inputSize * inputSize]; // array to copy values from Bitmap image

            //get pixel values from bitmap image and store it in intValues
            bitmap_scaled.getPixels(intValues, 0, bitmap_scaled.getWidth(), 0, 0, bitmap_scaled.getWidth(), bitmap_scaled.getHeight());

            float[] floatValues = new float[inputSize * inputSize];

            for(int i=0; i<intValues.length; ++i) {
                floatValues[i] = (intValues[i] & 0xFF);
            }

            //  the input size node that we declared earlier will be a parameter to reshape the tensor
            // fill the input node with floatValues array
            inferenceInterface.feed(INPUT_NODE, floatValues, INPUT_SHAPE);
            // make the inference
            inferenceInterface.run(new String[] {OUTPUT_NODE});
            // create an array filled zeros with dimension of number of output classes. In our case its 10
            float [] result = new float[10];
            Arrays.fill(result,0.0f);
            // copy the values from output node to the 'result' array
            inferenceInterface.fetch(OUTPUT_NODE, result);
            // find the class with highest probability
            int class_id = argmax(result);
            TextView textView=(TextView) findViewById(R.id.result);
            // Setting the class name in the UI
            textView.setText(classes[class_id]);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
