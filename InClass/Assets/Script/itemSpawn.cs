using UnityEngine;

public class itemSpawn : MonoBehaviour {
    public GameObject item;
    float t;
	// Use this for initialization
	void Start () {
		
	}
	
	// Update is called once per frame
	void Update () {
        t += Time.deltaTime;
        if (t > 10)
        {
            Vector3 position = new Vector3(0, 0, Random.Range(-2.5f, 2.5f));
            Instantiate(item, position, Quaternion.identity);
            t -= 10;
        }
    }



}
