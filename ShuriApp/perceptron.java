import java.util.ArrayList;

public class perceptron
{
    ArrayList<Integer> inputList = new ArrayList<Integer>();
    ArrayList<Float> weithList = new ArrayList<Float>();
    
    public perceptron()
    {
        
        inputList.add(1);
        weithList.add(1f);
    }

    


    public boolean activation(ArrayList<Integer> incomingInput)
    {
        float output = 0f;
        for(int x = 0; x < incomingInput.size(); x++)
        {
            inputList.add(incomingInput.get(x));
        }

        for(int x=1; x< incomingInput.size();x++)
        {
            output = output + inputList.get(x) * weithList.get(x);
        }
        
        return output >= weithList.get(0);
           
    }
}