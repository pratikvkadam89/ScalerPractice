package com.lld2.BuilderDesignPattern.Assignment2;

public class QueryBuilder {

    private String select;
    private String from;
    private String where;
    private String join;
    private String orderBy;
    private String groupBy;

    private QueryBuilder(Builder builder) {
        this.select = builder.select;
        this.from = builder.from;
        this.where = builder.where;
        this.join = builder.join;
        this.orderBy = builder.orderBy;
        this.groupBy = builder.groupBy;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        private String select;
        private String from;
        private String where;
        private String join;
        private String orderBy;
        private String groupBy;

        private Builder setSelect(String select) {
            this.select = select;
            return this;
        }
        private Builder setFrom(String from) {
            this.from = from;
            return this;
        }
        private Builder setWhere(String where) {
            this.where = where;
            return this;
        }
        private Builder setJoin(String join) {
            this.join = join;
            return this;
        }
        private Builder setOrderBy(String orderBy) {
            this.orderBy = orderBy;
            return this;
        }
        private Builder setGroupBy(String groupBy) {
            this.groupBy = groupBy;
            return this;
        }
        public QueryBuilder build() {
            return new QueryBuilder(this);
        }
    }
}
