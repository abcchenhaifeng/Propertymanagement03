<template>
    <div style="width: 75%; margin: 5% auto;">
        <form id="details" :action="action" method="post">
            <div class="form-item" v-for="(data, index) in computed_datas" :key='data.name'>
                <div class="input-group input-group-lg">
                    <div class="input-group-prepend">
                        <span class="input-group-text" :for="data.name">{{data.text}}</span>
                    </div>
                    <input 
                        :id="data.name"
                        :type="data.input_type" 
                        :name="data.name" 
                        v-model="model[data.name]" 
                        :readonly="index == 0 && readonly"
                        class="form-control" 
                        aria-label="Sizing example input"
                        aria-describedby="inputGroup-sizing-lg" 
                    >
                </div>
                <br>
            </div>
            <div class="input-group">
                <input type="text" class="form-control" disabled="disabled">
                <div class="input-group-append">
                    <a href="javascript: " class="btn btn-primary" @click="$emit('closeAlertBox')">返回</a>&nbsp;
                    <button class="btn btn-primary" type="submit" @click.prevent="operateHandle">{{curr_method}}</button>
                </div>
            </div>
        </form>
    </div>
</template>

<script>
import $ from 'jquery'
import 'jquery-form'
import BaseUrl from '../baseUrl.js'

export default {
    props: ['method', 'keyword'],
    data() {
        return {
            datas:[
                { name:'typeno', text:'类型编号', input_type:'number' },
                { name:'typename', text:'类型名称', input_type:'text' }
            ],
            model: {
                typeno: '',
                typename: '',
            },
            action: BaseUrl.url+'paytype/modify',
            filterEle: [''],
            curr_method: '修改',
            readonly: false,
            curr_keyword: this.keyword,

        }
    },

    computed: {
        computed_datas () {
            return this.datas.filter((ele)=>{ return this.filterEle.indexOf(ele.name) == -1 })
        }
    },

    created() {
        this.changeMethod(this.method);
    },

    watch: {
        method ( newVal ) {
            this.changeMethod(newVal);
        },

        keyword ( newVal ) {
            this.curr_keyword = newVal;
        }
    },

    methods: {
        operateHandle ( ) {
            var _this = this;
            $.post(this.action, this.model, function (rs) {
                _this.$emit('closeAlertBox');
                _this.$emit('reloadList');
            }).fail(function(){
                confirm('操作失败');
            });
        },

        changeMethod ( method_name ) {

            var _this = this;

            if ( method_name == 'add' ) {
                this.readonly = false;
                this.action = BaseUrl.url+'paytype/add';
                this.filterEle.push('typeno');
                this.curr_method = '添加';
            } else {
                this.readonly = true;
                this.action = BaseUrl.url+'paytype/modify';
                this.filterEle.pop();
                this.curr_method = '修改';

                var params = {
                    keyword: String(this.curr_keyword)
                }

                $(function(){
                    $.getJSON(BaseUrl.url+"paytype/get", params, function(data) {
                        _this.model.typeno = (data.model.typeno);
                        _this.model.typename = (data.model.typename);
                    });
                });
            }
        },

    },
}
</script>

<style scoped>

</style>