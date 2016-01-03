/**
 * @author Charbull
 * Jan 3, 2016 
 * semanticstore.jsonld.buildings.BuildingsBUItem.java
 */
package semanticstore.jsonld.buildings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldId;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldLink;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldProperty;
import semanticstore.util.jsonld.NS;
import semanticstore.util.jsonld.RefId;

@JsonldLink(name = NS.QT_NS, rel = NS.QT_URL)
@JsonldLink(name = NS.BDEVICES_NS, rel = NS.BDEVICES_URL)

public class BuildingsBUItem {

	Map<String, List<RefId>> relations;
	
	

	private String type = null;
	
	public BuildingsBUItem(String id, String hasName, String type)
	{
		this.id = NS.BOC_NS+":" + id;
		this.hasName = hasName;
		this.type = type;
		relations = new HashMap<>();
	}
	
	@JsonldId
	public  String id;
	
	@JsonInclude(Include.NON_NULL)
	@JsonProperty("@type")
	public String getType()
	{
		return NS.BDEVICES_NS+":"+type;
	}
	
	@JsonInclude(Include.NON_EMPTY)
	@JsonProperty(NS.hasPhysicalLocation)
	public List<RefId> getPhysicalLocation()
	{
		return relations.get(NS.hasPhysicalLocation);
	}
	
	public void hasPhysicalLocation(RefId refId)
	{
		List<RefId> ll = relations.get(NS.hasPhysicalLocation);
		if(ll ==null) ll = new ArrayList<>();
		ll.add(refId);
		relations.put(NS.hasPhysicalLocation, ll);
	}
	
	@JsonInclude(Include.NON_EMPTY)
	@JsonProperty(NS.hasMonitoringLocation)
	public List<RefId> getMonitoringLocation()
	{
		return relations.get(NS.hasMonitoringLocation);
	}
	
	public void hasMonitoringLocation(RefId refId)
	{
		List<RefId> ll = relations.get(NS.hasMonitoringLocation);
		if(ll ==null) ll = new ArrayList<>();
		ll.add(refId);
		relations.put(NS.hasMonitoringLocation, ll);
	}
	
	@JsonInclude(Include.NON_EMPTY)
	@JsonProperty(NS.connectsTo)
	public List<RefId> getConnects()
	{
		return relations.get(NS.connectsTo);
	}
	
	public void connectsTo(RefId refId)
	{
		List<RefId> ll = relations.get(NS.connectsTo);
		if(ll ==null) ll = new ArrayList<>();
		ll.add(refId);
		relations.put(NS.connectsTo, ll);
	}
	
	
	@JsonInclude(Include.NON_EMPTY)
	@JsonProperty(NS.monitors)
	public List<RefId> getMonitors()
	{
		return relations.get(NS.monitors);
	}
	
	public void monitors(RefId refId)
	{
		List<RefId> ll = relations.get(NS.monitors);
		if(ll ==null) ll = new ArrayList<>();
		ll.add(refId);
		relations.put(NS.monitors, ll);
	}
	
	@JsonInclude(Include.NON_EMPTY)
	@JsonProperty(NS.controls)
	public List<RefId> getControls()
	{
		return relations.get(NS.controls);
	}
	
	public void controls(RefId refId)
	{
		List<RefId> ll = relations.get(NS.controls);
		if(ll ==null) ll = new ArrayList<>();
		ll.add(refId);
		relations.put(NS.controls, ll);
	}
	
	
	@JsonInclude(Include.NON_EMPTY)
	@JsonProperty(NS.hasTimeSeries)
	public List<RefId> getTimeSeries()
	{
		return relations.get(NS.hasTimeSeries);
	}
	
	public void hasTimeSeries(RefId refId)
	{
		List<RefId> ll = relations.get(NS.hasTimeSeries);
		if(ll ==null) ll = new ArrayList<>();
		ll.add(refId);
		relations.put(NS.hasTimeSeries, ll);
	}
	
	@JsonInclude(Include.NON_EMPTY)
	@JsonProperty(NS.hasCommunicationMedium)
	public List<RefId> getCommunicationMedium()
	{
		return relations.get(NS.hasCommunicationMedium);
	}
	
	public void hasCommunicationMedium(RefId refId)
	{
		List<RefId> ll = relations.get(NS.hasCommunicationMedium);
		if(ll ==null) ll = new ArrayList<>();
		ll.add(refId);
		relations.put(NS.hasCommunicationMedium, ll);
	}
	
	@JsonldProperty(NS.hasName)
	@JsonInclude(Include.NON_NULL)
	public String hasName;
	
	@JsonIgnore
	public RefId getRefId()
	{
		return new RefId(id);
	}
}