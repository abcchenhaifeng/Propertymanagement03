<template>
    <div id="box-body">
        <table id="paytypeGrid" class="table table-bordered"></table>
		<div id="paytypeGridPager"></div>
    </div>
</template>

<script>
import $ from 'jquery'
import 'jqGrid/js/jquery.jqGrid.min.js'
import 'jqGrid/css/ui.jqgrid-bootstrap.css'
import 'jqGrid/js/i18n/grid.locale-cn.js'
import BaseUrl from '../baseUrl.js'

export default {
    data() {
        return {
            tableDom: null,
        }
    },
    methods: {
        reloadList( formData ){
            this.tableDom.jqGrid('clearGridData').jqGrid('setGridParam', {
                datatype: "json",
                page: 1,
                postData : formData
            }, true).trigger("reloadGrid");
        },

        getSelectRow () {
            return this.tableDom.jqGrid("getGridParam","selrow");
        }
    },
    mounted() {
        // 显示列表
        $.jgrid.defaults.styleUI = 'Bootstrap';
        this.tableDom = $("table#paytypeGrid");
        this.tableDom.jqGrid({
            url: BaseUrl.url+'paytype/list/page',
            datatype: "json",
            colModel: [
                { label: '类型编号', name: 'typeno' },
                { label: '类型名称', name: 'typename' }
            ],
            viewrecords: true, 
            autowidth: true,
            width: 'auto',
            height: 365,
            rowNum: 10,
            rowList:[10,20,30],
            loadonce: false,
            jsonReader : { 
                root: "list", 
                page: "page", 
                total: "pageCount", 
                records: "count", 
                repeatitems: true, 
                id: "typeno"
            },
            pager: "#paytypeGridPager",
            multiselect:false,
        });
    },
}
</script>

<style scoped>
    .ui-th-div {
        height: auto !important;
    }
    .ui-jqgrid .ui-jqgrid-htable .ui-th-div {
        height: auto !important;
    }
</style>