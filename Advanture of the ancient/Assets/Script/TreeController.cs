using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class TreeController : MonoBehaviour {
    private GameObject PlayerArm;
    private int Delete = 0;

	// Use this for initialization
	void Start () {
        PlayerArm = GameObject.Find("PlayerArm");
	}
	
	// Update is called once per frame
	void Update () {
	    	
	}
    void OnTriggerEnter (Collider other)
    {

        if(other==PlayerArm.GetComponent<Collider>())
        {
            //PlayerController.reacable = true;
            Delete++;
            Debug.Log("Tree ="+Delete);
            if (Delete > 2)
                Destroy(gameObject);
        }
    }

}
