using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class SpaceShipController : MonoBehaviour {
    public AudioClip bewbew;
    public GameObject Bullet,BulletR,BulletL;
    public Transform BulletMSpawn, BulletLSpawn, BulletRSpawn;
    public static bool GetItem = false;
    float t = 0;
    bool pause = false;
    public GameObject ReportItem;

    // Use this for initialization
    void Start () {
    }
	
	// Update is called once per frame
	void Update () {

        if (Input.GetAxis("Horizontal") != 0)
        {
            gameObject.transform.Translate(Input.GetAxis("Horizontal") * Vector3.right * Time.deltaTime * 5f);
        }
        if(Input.GetAxis("Vertical")!=0)
        {
            gameObject.transform.Translate(Input.GetAxis("Vertical") * Vector3.forward * Time.deltaTime*7f);
        }
        if (GetItem == true)
        {
            t += Time.deltaTime;
            ReportItem.GetComponent<TextMesh>().text = "ITEM TIME = " + (int)(6 - t);
            Debug.Log("Item time = " + t);
            if (t > 5)
        
            {
                ReportItem.GetComponent<TextMesh>().text = "";
                t = 0;
                GetItem = false;
            }
        }
        
            if (Input.GetKeyDown(KeyCode.Space)){
            Instantiate(Bullet, BulletMSpawn.position,BulletMSpawn.rotation);
            if (GetItem == true)
            {
                Instantiate(BulletL, BulletLSpawn.position, BulletLSpawn.rotation);
                Instantiate(BulletR, BulletRSpawn.position, BulletRSpawn.rotation);

            }
            this.gameObject.GetComponent<AudioSource>().clip = bewbew;
            this.gameObject.GetComponent<AudioSource>().Play();
        }
        if (Input.GetKeyDown(KeyCode.Escape)){
            if (!pause)
            {
                Time.timeScale = 0;
                pause = true;
            }
            else
            {
                Time.timeScale = 1;
                pause = false;
            }
            Debug.Log("PAUSE");
        }

    }
}
