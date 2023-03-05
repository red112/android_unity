using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class UIEvent : MonoBehaviour
{
    public Text resultText;


    AndroidJavaClass    unityClass;
    AndroidJavaObject   unityActivity;
    AndroidJavaObject   _pluginInstance;

    // Start is called before the first frame update
    void Start()
    {
        Debug.Log("Spript is ready.");
        InitializePlugin("com.red.myaarlibadd.libadd");

    }

    // Update is called once per frame
    void Update()
    {

    }

    public void OnClickButtion()
    {
        Debug.Log("Button is pressed.");
        int minutes = System.DateTime.Now.Minute;
        int seconds = System.DateTime.Now.Second;
        int sum = minutes + seconds;

        if (_pluginInstance != null)
        {
            sum = _pluginInstance.Call<int>("AddInt", minutes, seconds);
            string result = string.Format("{0} + {1} = {2}", minutes, seconds, sum);
            Debug.Log(result);
            resultText.text = result;
        }
        else
        {
            Debug.Log("Instance is null");
            resultText.text = "Initance is null";
        }

    }

    void InitializePlugin(string pluginName)
    {
        unityClass = new AndroidJavaClass("com.unity3d.player.UnityPlayer");
        unityActivity = unityClass.GetStatic<AndroidJavaObject>("currentActivity");
        _pluginInstance = new AndroidJavaObject(pluginName);

        if(_pluginInstance == null)
        {
            Debug.Log("Plugin Instance Error");
            resultText.text = "Plugin Instance Error";
        }

        _pluginInstance.CallStatic("receiveUnityActivity", unityActivity);
    }

    
}
