/**
 * @author Charbull
 * Jan 3, 2016 
 * semanticstore.util.jsonld.RefId.java
 */
package semanticstore.util.jsonld;

import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldId;

public class RefId {

	@JsonldId
	public String id;
	
	public RefId(String id)
	{
		this.id = id;
	}
}
