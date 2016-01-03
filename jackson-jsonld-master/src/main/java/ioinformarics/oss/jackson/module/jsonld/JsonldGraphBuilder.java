package ioinformarics.oss.jackson.module.jsonld;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Function;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * @author Alexander De Leon
 */
public class JsonldGraphBuilder<T> {

    protected String context;
    protected String graphType;
    protected String graphId;
    protected JsonldResourceBuilder<T> resourceBuilder;
    protected Function<T, String> typeSupplier;

    JsonldGraphBuilder() {
        resourceBuilder = new JsonldResourceBuilder<T>();
    }

    public JsonldGraphBuilder<T> context(String context){
        this.context = context;
        return this;
    }

    public JsonldGraphBuilder<T> type(String type){
        this.graphType = type;
        return this;
    }

    public JsonldGraphBuilder<T> id(String id){
        this.graphId = id;
        return this;
    }

    public JsonldGraphBuilder<T> elementId(Function<T,String> idSupplier){
        this.resourceBuilder.id(idSupplier);
        return this;
    }

    public JsonldGraphBuilder<T> elementType(Function<T,String> typeSupplier){
        this.typeSupplier = typeSupplier;
        return this;
    }

    public JsonldResource build(Iterable<T> elements) {
        Optional<JsonNode> generatedContext = JsonldContextFactory.multiContext(Optional.ofNullable(context), JsonldContextFactory.fromAnnotations(elements));
        return new JsonldGraph(buildElements(elements), generatedContext.orElse(null), graphType, graphId);

    }

    protected String getType(T e) {
        return typeSupplier.apply(e);
    }

    protected Iterable<JsonldResource> buildElements(Iterable<T> elements) {
        ArrayList<JsonldResource> list = new ArrayList<>();
        elements.forEach(e -> {
            JsonldResourceBuilder builder = JsonldResource.Builder.create();
            builder.type(resourceBuilder.getType(e));
            builder.id(resourceBuilder.getId(e));
            builder.context(null);
            list.add(builder.build(e, true));
        });
        return list;
    }


}
