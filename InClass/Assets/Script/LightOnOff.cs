using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class LightOnOff : MonoBehaviour {
    public GameObject MyLight;
    // Use this for initialization
    string alert = "Turn Off";
	void Start () {
		
	}
	
	// Update is called once per frame
	void Update () {

    }

    void OnGUI ()
    {
        
        if(GUI.Button(new Rect(Screen.width/2.0f-50, Screen.height/2.0f-50, 100, 100), alert) )
        {
            Debug.Log("Turn light On/Off"+ Time.time);
            Light but =MyLight.GetComponent<Light>();
            if (but.enabled == false)
            {
                but.enabled = true;
                alert = "Turn off";
            }
            else
            {
                but.enabled = false;
                alert = "Turn on";
            }
        }

    }
}
