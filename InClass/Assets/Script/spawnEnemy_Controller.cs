using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class spawnEnemy_Controller : MonoBehaviour {
    public GameObject enemy;
    float t=0;
    int stage = 0;
    float counter = 10;
    float stack = 0;
    float maxstack = 0;
    float upstage = 1;
    public GameObject ReportStage;
    // Use this for initialization
    void Start () {
	}
	 
	// Update is called once per frame
	void Update () {
        t += Time.deltaTime;
        //Debug.Log("Time = " + t);
        stage = (int)t/10;
        if (stage > upstage)
        {
            ReportStage.GetComponent<TextMesh>().text="STAGE : "+stage;
            maxstack += 0.05f;
            upstage++;
        }
      //  Debug.Log("Stage = "+stage);
        if (counter - stack < 0)
        {

            Vector3 position = new Vector3(Random.Range(-7f, 8.5f), 10, 0);
            Instantiate(enemy, position, Quaternion.identity);
            stack = 0;
        }
        else
        {
            stack += 0.1f+maxstack;
    //        Debug.Log("stack = " + stack);
        }
    }

}
