using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class itemController : MonoBehaviour {

	// Use this for initialization
	void Start () {
		
	}
	
	// Update is called once per frame
	void Update () {

    }
    void OnTriggerEnter(Collider other)
    {
        SpaceShipController.GetItem = true;
        Debug.Log("TRIGGER ME SO BAD");
        Destroy(this.gameObject);
    }
}
