using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class hpController : MonoBehaviour {
    public GameObject hp1;
    public GameObject hp2;
    public GameObject hp3;
    int count = 0;
    // Use this for initialization
    void Start () {
		
	}
	
	// Update is called once per frame
	void Update () {
		
	}
    void OnTriggerEnter(Collider other)
    {
        //  this.gameObject.GetComponent<AudioSource>().Play();
        if (count == 0)
            Destroy(hp1);
        if (count == 1)
            Destroy(hp2);
        if (count == 2)
        {
            Destroy(hp3);
            Destroy(this.gameObject);
        }
        Debug.Log("count = " + count);
        count++;
    }
}
