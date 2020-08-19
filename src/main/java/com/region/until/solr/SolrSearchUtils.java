package com.region.until.solr;

import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

import com.region.moudles.system.dto.MedicantTypeDto;
import com.region.until.StringUntil;

/**
 *@ClassName:SolrSearchUtils.java
 *@ClassDescribe:操作solr
 *@author:tianz
 *@createDate:2019年6月5日
 *@version
 */

public class SolrSearchUtils {
	
	private static String SOLR_URL = "http://192.168.1.248:8983/solr/wenda";
    
    /**
     *
     * @param keyword 搜索的关键词
     * @param offset 翻页
     * @param count 翻页
     * @param hlPer  高亮的前缀
     * @param hlPos 高亮的后缀
     * @return
     * 	搜索
     */
    public static List<MedicantTypeDto> searchQuestion(String keyword) throws Exception{
        List<MedicantTypeDto> questionList = new ArrayList<>();
        //solr的相关配置
        SolrQuery query = new SolrQuery();
        //无条件返回空；有条件判断是拼音还是名称
        if(!StringUntil.isNull(keyword)) {
        	String str = (keyword.length() < 4 ? (keyword + "*") : keyword);
    		query.setQuery("simple_py:" + str);
        }else {
        	return questionList;
        }
        query.setRows(1000);
        query.setStart(0);
        query.setHighlight(true);         //高亮
        HttpSolrClient client = new HttpSolrClient.Builder(SOLR_URL).build();
        QueryResponse response = client.query(query);
        SolrDocumentList solrDocuments = response.getResults();
        //解析搜索的界面的东西
        if(solrDocuments.size() > 0) {
        	for(SolrDocument info : solrDocuments) {
        		MedicantTypeDto med = new MedicantTypeDto();
        		med.setId(info.get("id") == null ? "" :info.get("id").toString());
        		med.setCode(info.get("code") == null ? "" : info.get("code").toString());
        		med.setName(info.get("name") == null ? "" : info.get("name").toString());
        		med.setSimplePinyin(info.get("simple_py") == null ? "" : info.get("simple_py").toString());
        		med.setUsage(info.get("usage") == null ? "" : info.get("usage").toString());
        		questionList.add(med);
        	}
        }
        client.commit();
        return questionList;
    }
    
}