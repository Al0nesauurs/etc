/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.0.M13
 * Generated at: 2017-11-14 09:44:07 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.net.URLEncoder;
import java.net.URLDecoder;
import java.nio.file.Paths;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.th.ThaiAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleFragmenter;
import org.apache.lucene.store.FSDirectory;

public final class results_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {


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
 
  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/configuration.jsp", Long.valueOf(1510617456127L));
    _jspx_dependants.put("/footer.jsp", Long.valueOf(1510487600816L));
    _jspx_dependants.put("/header.jsp", Long.valueOf(1510501060669L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("java.io");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("org.apache.lucene.search.Query");
    _jspx_imports_classes.add("org.apache.lucene.queryparser.classic.ParseException");
    _jspx_imports_classes.add("org.apache.lucene.search.TopDocs");
    _jspx_imports_classes.add("java.net.URLDecoder");
    _jspx_imports_classes.add("org.apache.lucene.analysis.TokenStream");
    _jspx_imports_classes.add("org.apache.lucene.search.ScoreDoc");
    _jspx_imports_classes.add("org.apache.lucene.analysis.Analyzer");
    _jspx_imports_classes.add("org.apache.lucene.index.DirectoryReader");
    _jspx_imports_classes.add("org.apache.lucene.analysis.th.ThaiAnalyzer");
    _jspx_imports_classes.add("org.apache.lucene.search.highlight.QueryScorer");
    _jspx_imports_classes.add("java.net.URLEncoder");
    _jspx_imports_classes.add("org.apache.lucene.document.Document");
    _jspx_imports_classes.add("org.apache.lucene.analysis.standard.StandardAnalyzer");
    _jspx_imports_classes.add("org.apache.lucene.search.highlight.Highlighter");
    _jspx_imports_classes.add("java.nio.file.Paths");
    _jspx_imports_classes.add("org.apache.lucene.queryparser.classic.QueryParser");
    _jspx_imports_classes.add("org.apache.lucene.search.highlight.SimpleFragmenter");
    _jspx_imports_classes.add("org.apache.lucene.search.highlight.InvalidTokenOffsetsException");
    _jspx_imports_classes.add("org.apache.lucene.store.FSDirectory");
    _jspx_imports_classes.add("org.apache.lucene.index.IndexReader");
    _jspx_imports_classes.add("org.apache.lucene.search.IndexSearcher");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!--\r\n");
      out.write("    Licensed to the Apache Software Foundation (ASF) under one or more\r\n");
      out.write("    contributor license agreements.  See the NOTICE file distributed with\r\n");
      out.write("    this work for additional information regarding copyright ownership.\r\n");
      out.write("    The ASF licenses this file to You under the Apache License, Version 2.0\r\n");
      out.write("    the \"License\"); you may not use this file except in compliance with\r\n");
      out.write("    the License.  You may obtain a copy of the License at\r\n");
      out.write(" \r\n");
      out.write("        http://www.apache.org/licenses/LICENSE-2.0\r\n");
      out.write(" \r\n");
      out.write("    Unless required by applicable law or agreed to in writing, software\r\n");
      out.write("    distributed under the License is distributed on an \"AS IS\" BASIS,\r\n");
      out.write("    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\r\n");
      out.write("    See the License for the specific language governing permissions and\r\n");
      out.write("    limitations under the License.\r\n");
      out.write(" -->\r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write(" ");
      out.write("\r\n");
      out.write(" <div>\r\n");
      out.write("     <a href=\"/luceneweb\">\r\n");
      out.write("     <img src = \"Logo.jpg\" style=\" width: 180px; float: left; position:sticky\" />\r\n");
      out.write("     </a>\r\n");
      out.write("     <form name=\"search\" action=\"results.jsp\" method=\"get\" style=\" float: none; width: auto; overflow: hidden;\">\r\n");
      out.write("         <div>\r\n");
      out.write("             <p>\r\n");
      out.write("                 <input name=\"query\" size=\"44\" placeholder=\"Type your document here...\"/>&nbsp;\r\n");
      out.write("             </p>\r\n");
      out.write("             <p>\r\n");
      out.write("                Search method\r\n");
      out.write("                <div >\r\n");
      out.write("                        <input type=\"radio\" name=\"type_search\" value=\"Pagerank\" id=\"option1\" autocomplete=\"off\" > Pagerank\r\n");
      out.write("                        <input type=\"radio\" name=\"type_search\" value=\"Similarity\" id=\"option2\" autocomplete=\"off\"> Similarity\r\n");
      out.write("                        <input type=\"radio\" name=\"type_search\" value=\"Rerank\" id=\"option3\" autocomplete=\"off\"> Rerank\r\n");
      out.write("                </div>\r\n");
      out.write("                 <br></br>\r\n");
      out.write("                 <input name=\"maxresults\" size=\"4\" value=\"10\"/>&nbsp;Results Per Page&nbsp;\r\n");
      out.write("                 <input type=\"submit\" value=\"Search\"/>\r\n");
      out.write("           </p>\r\n");
      out.write("         </div>\r\n");
      out.write("     </form>\r\n");
      out.write("     </div>\r\n");
      out.write(" </div>\r\n");
      out.write(" ");

 String search_option_old = request.getParameter("type_search");
 
      out.write("\r\n");
      out.write("  <script>myval =\"");
      out.print(search_option_old);
      out.write("\";</script>\r\n");
      out.write("\r\n");
      out.write("  <script type=\"text/javascript\">\r\n");
      out.write("      console.log(myval);\r\n");
      out.write("      if (myval == \"Pagerank\"){\r\n");
      out.write("          document.getElementById(\"option1\").checked = true;\r\n");
      out.write("      }\r\n");
      out.write("      else if(myval ==\"Similarity\"){\r\n");
      out.write("          document.getElementById(\"option2\").checked = true;\r\n");
      out.write("      }\r\n");
      out.write("      else{\r\n");
      out.write("          document.getElementById(\"option3\").checked = true;\r\n");
      out.write("      }\r\n");
      out.write("  </script>\r\n");
      out.write(" ");
      out.write("<!--\n");
      out.write("    Licensed to the Apache Software Foundation (ASF) under one or more\n");
      out.write("    contributor license agreements.  See the NOTICE file distributed with\n");
      out.write("    this work for additional information regarding copyright ownership.\n");
      out.write("    The ASF licenses this file to You under the Apache License, Version 2.0\n");
      out.write("    the \"License\"); you may not use this file except in compliance with\n");
      out.write("    the License.  You may obtain a copy of the License at\n");
      out.write(" \n");
      out.write("        http://www.apache.org/licenses/LICENSE-2.0\n");
      out.write(" \n");
      out.write("    Unless required by applicable law or agreed to in writing, software\n");
      out.write("    distributed under the License is distributed on an \"AS IS\" BASIS,\n");
      out.write("    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n");
      out.write("    See the License for the specific language governing permissions and\n");
      out.write("    limitations under the License.\n");
      out.write(" -->\n");
      out.write("<!--\n");
      out.write("    Licensed to the Apache Software Foundation (ASF) under one or more\n");
      out.write("    contributor license agreements.  See the NOTICE file distributed with\n");
      out.write("    this work for additional information regarding copyright ownership.\n");
      out.write("    The ASF licenses this file to You under the Apache License, Version 2.0\n");
      out.write("    the \"License\"); you may not use this file except in compliance with\n");
      out.write("    the License.  You may obtain a copy of the License at\n");
      out.write(" \n");
      out.write("        http://www.apache.org/licenses/LICENSE-2.0\n");
      out.write(" \n");
      out.write("    Unless required by applicable law or agreed to in writing, software\n");
      out.write("    distributed under the License is distributed on an \"AS IS\" BASIS,\n");
      out.write("    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n");
      out.write("    See the License for the specific language governing permissions and\n");
      out.write("    limitations under the License.\n");
      out.write(" -->\n");

/* Author: Andrew C. Oliver (acoliver2@users.sourceforge.net) */
String appTitle = "Monday Saturday Search";
/* make sure you point the below string to the index you created with IndexHTML */
String indexLocation = "W:\\Program\\eclipse\\WorkSpace\\Lucene\\index";
String appfooter = "Apache Lucene Template WebApp 1.0";

      out.write('\n');
      out.write('\n');
      out.write('\n');
 /* Author: Andrew C. Oliver (acoliver2@users.sourceforge.net */ 
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<title>");
      out.print(appTitle);
      out.write("</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<p align=\"center\">\n");
      out.write("\n");
      out.write("  </div>\n");
      out.write("</p>\n");
      out.write('\r');
      out.write('\n');
      out.write(' ');

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
     
      out.write("\r\n");
      out.write("                 <p>ERROR opening the Index - contact sysadmin!</p>\r\n");
      out.write("                 <p>Error message: ");
      out.print(escapeHTML(e.getMessage()));
      out.write("</p>   \r\n");
      out.write(" ");
                error = true;                                  //don't do anything up to the footer
         }
 
      out.write('\r');
      out.write('\n');
      out.write(' ');

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
                                                                       
 
      out.write("\r\n");
      out.write("                         <p>Error while parsing query: ");
      out.print(escapeHTML(e.getMessage()));
      out.write("</p>\r\n");
      out.write(" ");

                         error = true;                                 //don't bother with the rest of
                                                                       //the page
                 }
         }
 
      out.write('\r');
      out.write('\n');
      out.write(' ');

         if (error == false && searcher != null) {                     // if we've had no errors
                                                                       // searcher != null was to handle
                                                                       // a weird compilation bug 
                 thispage = maxpage;                                   // default last element to maxpage
                 hits = searcher.search(query, maxpage + startindex);  // run the query 
                 if (hits.totalHits == 0) {                             // if we got no results tell the user
 
      out.write("\r\n");
      out.write("                 <p> I'm sorry I couldn't find what you were looking for. </p>\r\n");
      out.write(" ");

                 error = true;                                        // don't bother with the rest of the
                                                                      // page
                 }
         }
 
         if (error == false && searcher != null) {                   
 
      out.write("\r\n");
      out.write(" <div class=\"row\" style=\"float:right; width : 80%; left: 20%\">\r\n");
      out.write("     <table >\r\n");
      out.write("            ");

            if ((startindex + maxpage) > hits.totalHits) {
                thispage = hits.totalHits - startindex;      // set the max index to maxpage or last
            }                                                   // actual search result whichever is less
            float alpha = 0.65f;
            class NewRank {
                float Page_Rank;
                float Re_Rank;
                float Sim_Rank;
                Document Doc;
            };
            NewRank[] ranking = new NewRank[hits.totalHits];
            for (int i = startindex; i < (thispage + startindex); i++) {
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
             }
                }
                catch (Exception e){
                
                } 
              

             
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" ");

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
 
      out.write("\r\n");
      out.write(" \r\n");
      out.write("     <tr>\r\n");
      out.write("         <td>");
      out.print(i+1);
      out.write("&nbsp;&nbsp;</td><td><a href=");
      out.print("http://"+doc.get("html"));
      out.write(" style=\"color:blue;text-decoration: none;\">");
      out.print(doctitle);
      out.write("</a></td>\r\n");
      out.write("         <td> Page rank score : ");
      out.print(pagerank);
      out.write("  </td>\r\n");
      out.write("     </tr>\r\n");
      out.write("     <tr>\r\n");
      out.write("         <td></td><td><a  style=\"color:green;text-decoration: none;\">");
      out.print(html);
      out.write("</a></td>\r\n");
      out.write("     </tr>\r\n");
      out.write("     <tr>\r\n");
      out.write("         <td></td><td style=\" margin:10px;\r\n");
      out.write("                        overflow: hidden;\r\n");
      out.write("                        text-overflow: ellipsis;\r\n");
      out.write("                        display: -webkit-box;\r\n");
      out.write("                        -webkit-line-clamp: 3;\r\n");
      out.write("                        -webkit-box-orient: vertical;\">");
      out.print(doc.get("contents"));
      out.write("</td>\r\n");
      out.write("     </tr>\r\n");
      out.write("     <tr><td>&nbsp;</td><td></td></tr>\r\n");
      out.write(" ");

         }
 
      out.write('\r');
      out.write('\n');
      out.write(' ');
      if ( (startindex + maxpage) < hits.totalHits) {   //if there are more results...display 
                                                                    //the more link
 
         String moreurl="results.jsp?query=" + 
         URLEncoder.encode(queryString) +  //construct the "more" link
         "&amp;maxresults=" + maxpage + 
         "&amp;startat=" + (startindex + maxpage);
 
      out.write("\r\n");
      out.write("         <tr>\r\n");
      out.write("             <td></td><td><a href=\"");
      out.print(moreurl);
      out.write("\">Next Results>></a></td>\r\n");
      out.write("         </tr>\r\n");
      out.write(" ");

                 }
 
      out.write("\r\n");
      out.write("                 </table>\r\n");
      out.write("         </div>\r\n");
      out.write(" </div>\r\n");
      out.write(" ");
       }                                    //then include our footer.
          //if (searcher != null)
          //       searcher.close();
 
      out.write('\r');
      out.write('\n');
      out.write(' ');
      out.write("<!--\n");
      out.write("    Licensed to the Apache Software Foundation (ASF) under one or more\n");
      out.write("    contributor license agreements.  See the NOTICE file distributed with\n");
      out.write("    this work for additional information regarding copyright ownership.\n");
      out.write("    The ASF licenses this file to You under the Apache License, Version 2.0\n");
      out.write("    the \"License\"); you may not use this file except in compliance with\n");
      out.write("    the License.  You may obtain a copy of the License at\n");
      out.write(" \n");
      out.write("        http://www.apache.org/licenses/LICENSE-2.0\n");
      out.write(" \n");
      out.write("    Unless required by applicable law or agreed to in writing, software\n");
      out.write("    distributed under the License is distributed on an \"AS IS\" BASIS,\n");
      out.write("    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n");
      out.write("    See the License for the specific language governing permissions and\n");
      out.write("    limitations under the License.\n");
      out.write(" -->\n");
 /* Author Andrew C. Oliver (acoliver2@users.sourceforge.net) */ 
      out.write("\n");
      out.write("<p align=\"center\">\n");
      out.write("\t<!-- ");
      out.print(appfooter);
      out.write(" -->\n");
      out.write("</p>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("        \r\n");
      out.write(" ");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
