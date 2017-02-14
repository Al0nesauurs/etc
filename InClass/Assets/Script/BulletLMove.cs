using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class BulletLMove : MonoBehaviour {

    void Start()
    {
    }

    // Update is called once per frame
    void Update()
    {

        this.gameObject.transform.Translate(Vector3.up * Time.deltaTime * 10f);
        this.gameObject.transform.Translate(Vector3.left * Time.deltaTime * 10f);

        if (this.gameObject.transform.position.y >= 20f)
        {
            Destroy(this.gameObject);

        }
    }
    void OnTriggerEnter(Collider other)
    {
        //this.gameObject.GetComponent<AudioSource>().clip = explode;
        //this.gameObject.GetComponent<AudioSource>().Play();
        Destroy(other.gameObject);

        Destroy(this.gameObject);
    }
}
