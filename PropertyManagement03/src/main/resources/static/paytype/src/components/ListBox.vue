<template>
    <div id="list-box">
        <box-header ref="box-header" @reloadList="reloadList" @operate="( method ) => { this[method](); }"></box-header>
        <box-body ref="box-body"></box-body>
    </div>
</template>

<script>
import BoxHeader from './BoxHeader.vue'
import BoxBody from './BoxBody.vue'

export default {
    components: {
        BoxHeader, BoxBody
    },
    methods: {
        reloadList( datas ){
            this.$refs['box-body'].reloadList(datas);
        },

        add () {
            this.$refs['box-header'].add();
        },

        modify () {
            var key = this.$refs['box-body'].getSelectRow();
            if ( key != null ) {
                this.$refs['box-header'].modify(key);
            } else {
                confirm("请选择一个类型");
            }
        },

        delete () {
            var key = this.$refs['box-body'].getSelectRow();
            if ( key != null ) {
                if ( confirm("确定要删除吗?") ) this.$refs['box-header'].delete(key);
            } else {
                confirm("请选择一个类型");
            }
        },

    },
}
</script>

<style scoped>

</style>