using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerArmController : MonoBehaviour {
    private float t=0;
    private bool hit = false;
	// Use this for initialization
	void Start () {
		
	}
	
	// Update is called once per frame
	void Update () {
        if (Input.GetKeyDown(KeyCode.Mouse0))
        {
            Debug.Log("Hit!");
            hit = true;
        //    gameObject.transform.Translate(Vector3.back * Time.deltaTime * 10f);

        }
        if(hit==true)
        {
            t += Time.deltaTime;
            if(t<=1)
                gameObject.transform.Translate(Vector3.forward * Time.deltaTime * 1f);
            if (t >= 1 && t < 2)
            {
                gameObject.transform.Translate(Vector3.back * Time.deltaTime * 1f);
            }
            if (t >= 2)
                {
                    hit = false;
                    t = 0;
                }
         }


    }
}
