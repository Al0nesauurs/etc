<!--
    Licensed to the Apache Software Foundation (ASF) under one or more
    contributor license agreements.  See the NOTICE file distributed with
    this work for additional information regarding copyright ownership.
    The ASF licenses this file to You under the Apache License, Version 2.0
    the "License"); you may not use this file except in compliance with
    the License.  You may obtain a copy of the License at
 
        http://www.apache.org/licenses/LICENSE-2.0
 
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
 -->
 <%@page pageEncoding="UTF-8"%>
 <%@ page import = " java.util.*, javax.servlet.*, javax.servlet.http.*, java.io.*, java.net.URLEncoder, java.net.URLDecoder, java.nio.file.Paths, org.apache.lucene.analysis.Analyzer, org.apache.lucene.analysis.TokenStream, org.apache.lucene.analysis.standard.StandardAnalyzer, org.apache.lucene.analysis.th.ThaiAnalyzer, org.apache.lucene.document.Document, org.apache.lucene.index.DirectoryReader, org.apache.lucene.index.IndexReader, org.apache.lucene.queryparser.classic.QueryParser, org.apache.lucene.queryparser.classic.ParseException, org.apache.lucene.search.IndexSearcher, org.apache.lucene.search.Query, org.apache.lucene.search.ScoreDoc, org.apache.lucene.search.TopDocs, org.apache.lucene.search.highlight.Highlighter, org.apache.lucene.search.highlight.InvalidTokenOffsetsException, org.apache.lucene.search.highlight.QueryScorer, org.apache.lucene.search.highlight.SimpleFragmenter, org.apache.lucene.store.FSDirectory" %>

 <%!
 public String escapeHTML(String s) {
   s = s.replaceAll("&", "&amp;");
   s = s.replaceAll("<", "&lt;");
   s = s.replaceAll(">", "&gt;");
   s = s.replaceAll("\"", "&quot;");
   s = s.replaceAll("'", "&apos;");
   return s;
 }
 public static String  highlighter (String snippet,String queries){
    String highlight_snippet = "";
        int index = (snippet.toLowerCase()).indexOf(queries.toLowerCase());
        int widely = 250;
        if (index == -1){
            return snippet.substring(0, Math.min(snippet.length(), 510)); 
        }
        for (int i = Math.max(0,index-widely) ; i < Math.min(index+queries.length()+widely, snippet.length()) ;i++){
            if(i==index){
                highlight_snippet += "<span style=\"color:red;\"><B>";
            }
            highlight_snippet += snippet.charAt(i);
            if (i == index+queries.length()-1){
                highlight_snippet += "</B></span>";
            }
        }
        return highlight_snippet;
                                     
    }
 %>
 <div style=" position:fixed ;width:1600px; background-color:#C0C0C0; top:0%; left:0%; height:130px" >
    <div style=" float: left; width: 200px; overflow: hidden; height:110px;">
            
    </div>
    <div>
      <a href="/luceneweb">
        <img src = "Logo2.jpg" style="float: left;  margin-top: 20px;" width="180px" height="60px" align="middle"/>
      </a>
    </div>
    <div style=" float: left; width: 50px; overflow: hidden; height:110px;">
        
    </div>
    <form name="search" action="results.jsp" method="get" style=" float: none; width: auto; overflow: hidden; height:130px">
        <div>
            <p>
                <input name="query" size="44" placeholder="Type your document here..."/>&nbsp;
                <input type="submit" value="Search"/>
                
            </p>
            <p>
               Search method
               <div >
                       <input type="radio" name="type_search" value="Pagerank" id="option1" autocomplete="off" > Pagerank
                       <input type="radio" name="type_search" value="Rerank" id="option2" autocomplete="off"> Rerank
                       <input type="radio" name="type_search" value="Random" id="option3" autocomplete="off"> Random
                       <input name="maxresults" size="4" value="10"/>&nbsp;Results Per Page&nbsp;
               </div>
                <br></br>
          </p>
        </div>
    </form>
 </div>
 <div style="height:130px"></div>
 <%
 String search_option_old = request.getParameter("type_search");
 %>
  <script>myval ="<%=search_option_old%>";</script>
  <script type="text/javascript">
    function getCookie (cname) {
      let name = cname + '='
      let decodedCookie = decodeURIComponent(document.cookie)
      let ca = decodedCookie.split(';')
      for (let i = 0; i < ca.length; i++) {
        let c = ca[i]
        while (c.charAt(0) === ' ') {
          c = c.substring(1)
        }
        if (c.indexOf(name) === 0) {
          return c.substring(name.length, c.length)
        }
      }
      return ''
    }
  </script>
  <script type="text/javascript">
    if (myval === null) {
        myval = getCookie("option")
    } else if (myval === 'Pagerank' || myval === 'Random' || myval === 'Rerank'){
      document.cookie = 'option=' + myval + '; expires=Thu, 18 Dec 2018 12:00:00 UTC; path=/';
      console.log(getCookie('option'))
    }

    if (myval == 'Pagerank') {
        document.getElementById('option1').checked = true;
    } else if (myval == 'Rerank') {
        document.getElementById('option2').checked = true;
    } else if(myval =='Random') {
        document.getElementById('option3').checked = true;
    }
    else {
        myval = getCookie('option')
        console.log(myval)
        if (myval == 'Pagerank'){
          document.getElementById('option1').checked = true;
        } else if(myval =='Rerank') {
              document.getElementById('option2').checked = true;
        } else if(myval =='Random') {
        document.getElementById('option3').checked = true;
      }
    }
  </script>
 <%@include file="header.jsp"%>
 <%
         boolean error = false;                  //used to control flow for error messages
         String indexName = indexLocation;       //local copy of the configuration variable
         IndexSearcher searcher = null;          //the searcher used to open/search the index
         Query query = null;                     //the Query created by the QueryParser
         TopDocs hits = null;                    //the search results
         int startindex = 0;                     //the first index displayed on this page
         int maxpage    = 50;                    //the maximum items displayed on this page
         String queryString = null;              //the query entered in the previous page
         String startVal    = null;              //string version of startindex
         String maxresults  = null;              //string version of maxpage
         int thispage = 0;                       //used for the for/next either maxpage or
                                                 //hits.totalHits - startindex - whichever is
         String search_option = "";
                                                 
                                                 //less
 
         try {
           IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get(indexName)));
           searcher = new IndexSearcher(reader);       
                                                         
         } catch (Exception e) {                        
     %>
                 <p>ERROR opening the Index - contact sysadmin!</p>
                 <p>Error message: <%=escapeHTML(e.getMessage())%></p>   
 <%                error = true;                                  //don't do anything up to the footer
         }
 %>
 <%
        if (error == false) {                                           //did we open the index?
                 //queryString = URLDecoder.decode(request.getParameter("query"),"UTF-8");           //get the search criteria
                 queryString = request.getParameter("query");           //get the search criteria
                 startVal    = request.getParameter("startat");         //get the start index
                 maxresults  = request.getParameter("maxresults");      //get max results per page
                 search_option = request.getParameter("type_search");
                 
                 try {
                         maxpage    = Integer.parseInt(maxresults);    //parse the max results first
                         startindex = Integer.parseInt(startVal);      //then the start index  
                 } catch (Exception e) { } //we don't care if something happens we'll just start at 0
                                           //or end at 50
 
                 
 
                 if (queryString == null)
                         throw new ServletException("no query "+       //if you don't have a query then
                                                    "specified");      //you probably played on the 
                                                                       //query string so you get the 
                                                                       //treatment
 
                 //Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_CURRENT);           //construct our usual analyzer
                 Analyzer analyzer = new ThaiAnalyzer();
                 try {
                         QueryParser qp = new QueryParser("contents", analyzer);
                         query = qp.parse(queryString.trim()); //parse the 
                 } catch (ParseException e) {                          //query and construct the Query
                                                                       //object
                                                                       //if it's just "operator error"
                                                                       //send them a nice error HTML
                                                                       
 %>
                         <p>Error while parsing query: <%=escapeHTML(e.getMessage())%></p>
 <%
                         error = true;                                 //don't bother with the rest of
                                                                       //the page
                 }
         }
 %>
 <%
         if (error == false && searcher != null) {                     // if we've had no errors
                                                                       // searcher != null was to handle
                                                                       // a weird compilation bug 
                 thispage = maxpage;                                   // default last element to maxpage
                 hits = searcher.search(query, 10000 + startindex);  // run the query 
                 if (hits.totalHits == 0) {                             // if we got no results tell the user
 %>
                 <p> I'm sorry I couldn't find what you were looking for. </p>
 <%
                 error = true;                                        // don't bother with the rest of the
                                                                      // page
                 }
         }
 
         if (error == false && searcher != null) {                   
 %>
 <div class="row" style="float:right; width : 85%; left: 15%">
    <td></td><td>Number of total page : <%=hits.totalHits%></td>
 </div>
 <div class="row" style="float:right; width : 85%; left: 15%">
     <table >
            <%
            if ((startindex + maxpage) > hits.totalHits) {
                thispage = hits.totalHits - startindex;      // set the max index to maxpage or last
            }                                                   // actual search result whichever is less
            float alpha = 0.65f;
            class NewRank {
                float Page_Rank;
                float Re_Rank;
                float Sim_Rank;
                Document Doc;
                double score;
            };
            NewRank[] ranking = new NewRank[hits.totalHits];
            for (int i = startindex; i < (hits.totalHits); i++) {
                Document doc = searcher.doc(hits.scoreDocs[i].doc);
                float sim = hits.scoreDocs[i].score ;
                    float pagerank = 0.0f;
                    try{
                        pagerank = Float.parseFloat(doc.get("PageRank"));
                    }
                    catch (Exception e){
                      //out.println("An exception occurred: " + e.getMessage());
                    } 
                ranking[i] = new NewRank();
                ranking[i].Page_Rank = pagerank;
                ranking[i].Re_Rank = pagerank*(1-alpha) + sim*alpha;
                ranking[i].Sim_Rank = sim ;
                ranking[i].Doc =  doc;
            }
               //out.print(search_option);
               //out.print(search_option.equals("Pagerank"));
            try{
                if(search_option.equals("Pagerank")){
                //out.print("1");
                Arrays.sort(ranking, new Comparator<NewRank>() {
                    public int compare(NewRank n1, NewRank n2) {
                        return Float.compare(n2.Page_Rank, n1.Page_Rank);
                    }
                });
             } else if (search_option.equals("Rerank"))  {
                Arrays.sort(ranking, new Comparator<NewRank>() {
                    public int compare(NewRank n1, NewRank n2) {
                        double score1 = 0, score2 = 0, omega = 0.5;
                        try{
                            score1 = omega*n1.score + (1-omega)*n1.Page_Rank;
                            score2 = omega*n2.score + (1-omega)*n2.Page_Rank;
                        } catch (Exception e) {
                            System.out.println("Exception :" + e);
                         }
                        if (score1 < score2) return (1);
                        else if (score1 == score2) return (0);
                        else return (-1);                    }
                });
             }
                }
                catch (Exception e){
                
                } 
              

             %>




 <%
     if ((startindex + maxpage) > hits.totalHits) {
             thispage = hits.totalHits - startindex;      // set the max index to maxpage or last
     }                                                   // actual search result whichever is less
     for (int i = startindex; i < (thispage + startindex); i++) {  // for each element
        Document doc = ranking[i].Doc ;
        String doctitle = doc.get("title");            //get its title
        String url = doc.get("path");   
        String html = doc.get("html");               //get its path field
        String content = doc.get("content");
        String pagerank = doc.get("PageRank");
        if (url != null && url.startsWith("../webapps/")) { // strip off ../webapps prefix if present
          url = url.substring(10);
        }
        if ((doctitle == null) || doctitle.equals("")) //use the path if it has no title
            doctitle = url;

        String body_content = doc.get("content");
        String snippet ;
        if (body_content != null) {
            snippet = highlighter(body_content,queryString.toLowerCase());
        }
 %>
 
     <tr>
         <td><%=i+1%>&nbsp;&nbsp;</td><td><a href=<%="http://"+doc.get("html")%> style="color:blue;text-decoration: none;"><%=doctitle%></a></td>
         <td style = "width:180px"> Page rank score : <%=pagerank%>  </td>
     </tr>
     <tr>
         <td></td><td><a  style="color:green;text-decoration: none;"><%=html%></a></td>
     </tr>
     <tr>
         <td></td><td style=" margin:10px;
                        overflow: hidden;
                        text-overflow: ellipsis;
                        display: -webkit-box;
                        -webkit-line-clamp: 3;
                        -webkit-box-orient: vertical;"><%=doc.get("contents")%></td>
     </tr>
     <tr><td>&nbsp;</td><td></td></tr>
 <%
         }
 %>
 <%      if ( (startindex + maxpage) < hits.totalHits) {   //if there are more results...display 
                                                                    //the more link
 
         String moreurl="results.jsp?query=" + 
         URLEncoder.encode(queryString) +  //construct the "more" link
         "&amp;maxresults=" + maxpage + 
         "&amp;startat=" + (startindex + maxpage);
 %>
         <tr>
             <td></td><td><a href="<%=moreurl%>">Next Results>></a></td>
         </tr>
 <%
                 }
 %>
                 </table>
         </div>
 </div>
 <%       }                                    //then include our footer.
          //if (searcher != null)
          //       searcher.close();
 %>
 <%@include file="footer.jsp"%>        
 