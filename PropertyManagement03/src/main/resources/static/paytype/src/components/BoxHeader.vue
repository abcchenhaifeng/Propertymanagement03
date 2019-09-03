<template>
    <div id="box-header" class="box-header">
        <div id="search-input">
            
            <form ref="search-from">
                <div class="form-row align-items-center">
                    <search-input 
                        v-for="data in input_datas"
                        :ref="data.id"
                        :key="data.id"
                        :t_data="data"
                    ></search-input>
                    <search-button @reloadList="$emit('reloadList', getInputData())" @reset="reset"></search-button>
                    <!-- <operate-button :datas="operate_datas" @operate="( method ) => { this[method](); }"></operate-button> -->
                    <operate-button :datas="operate_datas" @operate="( method ) => { $emit('operate', method); }"></operate-button>
                </div>
            </form>

        </div>
        <div id="loadArea" v-if="show">
            <details-box :keyword="key" :method="method" @closeAlertBox="closeAlertBox" @reloadList="$emit('reloadList', getInputData())"></details-box>
        </div>
    </div>
</template>

<script>
import SearchInput from './SearchInput.vue'
import SearchButton from './SearchButton.vue'
import OperateButton from './OperateButton.vue'
import DetailsBox from './DetailsBox.vue'
import $ from 'jquery'
import 'jquery-ui/ui/widgets/dialog'
import BaseUrl from '../baseUrl.js'

export default {
    data(  ) {
        return {
            input_datas:[
                { id:'typeno', text:'类型编号', input_type:'text' },
                { id:'typename', text:'类型名称', input_type:'text' }
            ],
            operate_datas: [
                { url:'feetype/details.html', text:'添加', method:'add' },
                { url:'feetype/details.html', text:'修改', method:'modify' },
                { url:'feetype/delete', text:'删除', method:'delete' },
            ],
            show: false,
            method: 'add',
            loadArea: $('#loadArea'),
            key: null,
        }
    },
    methods: {
        getInputData(  ) {
            var inputData = {};
            var _this = this;
            this.input_datas.forEach(element => {
                var val = _this.$refs[element.id][0].value;
                if ( val != '' ) {
                    inputData[element.id] = val;
                }
            });
            
            return inputData;
        },

        reset(  ) {
            var _this = this;
            this.input_datas.forEach(element => {
                _this.$refs[element.id][0].value = '';
            });
        },

        add(  ) {
            this.method = 'add';
            this.alertBox(this.method, '添加');
        },

        modify( key ) {
            this.method = 'modify';
            this.key = key;
            this.alertBox(this.method, '修改');
        },

        delete( key ) {
            var _this = this;
            $.post(BaseUrl.url+"paytype/delete", { keyword: key }, function (rs) {
                _this.$emit('reloadList', _this.getInputData());
            });
        },

        alertBox ( method, title  ) {
            this.method = method;
            var _this = this;
            _this.show = true;
            $(function(){
                _this.loadArea = $('#loadArea');
                _this.loadArea.dialog({
                    title: title,
                    width: "80%",
                    maxWidth: "845px",
                    close: function(event, ui) {
                        _this.closeAlertBox();
                    }
                });
            });
        },

        closeAlertBox (  ) {
            this.loadArea.dialog("destroy");
            this.loadArea = null;
            this.show = false;
        }
    },
    components: {
        SearchInput, SearchButton, OperateButton, DetailsBox
    }
}
</script>

<style scoped>
	
</style>