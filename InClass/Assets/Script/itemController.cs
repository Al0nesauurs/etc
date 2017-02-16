using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class itemController : MonoBehaviour {

    // Use this for initialization
    GameObject item;
    void Start () {
       item= GameObject.Find("Item(Clone)");
	}
	
	// Update is called once per frame
	void Update () {

    }
    void OnTriggerEnter(Collider other)
    {
        if (other != item)
        {
            SpaceShipController.GetItem = true;
            Debug.Log("TRIGGER ME SO BAD");

            Destroy(this.gameObject);
        }
    }
}
