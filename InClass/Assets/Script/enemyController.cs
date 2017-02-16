using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class enemyController : MonoBehaviour {
    public AudioClip explode;
    public int force = 1;
    GameObject Player,Building,Enemy;
    float t = 0;
    // Use this for initialization
    void Start () {
        // this.gameObject.GetComponent<AudioSource>().clip = explode;
        Player = GameObject.Find("Player");
        Building = GameObject.Find("MyBuilding");
        Enemy = GameObject.Find("Enemy 1(Clone)");

    }

    // Update is called once per frame
    void Update () {
        this.gameObject.transform.Translate(Vector3.down * Time.deltaTime * 1f*force);
    }

    void OnTriggerEnter (Collider other)
    {
        //  this.gameObject.GetComponent<AudioSource>().Play();
        if (other == Player.GetComponent<Collider>())
        {
            Destroy(Player);
            Destroy(Building);
            t += Time.deltaTime;
            if (t > 5)
                Application.Quit();
        }
        if(other !=Enemy)
         Destroy(this.gameObject);
    }
}
