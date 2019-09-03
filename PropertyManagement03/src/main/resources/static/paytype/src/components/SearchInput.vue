<template>
    <div class="col-auto my-1">
        <label class="sr-only" :for="t_data.id">{{t_data.text}}</label>
        <div class="input-group">
            <div class="input-group-prepend">
                <div class="input-group-text">{{t_data.text}}</div>
            </div>
            <input 
                :id="t_data.id"
                :type="t_data.input_type" 
                class="form-control" 
                v-model.trim="value"
                :placeholder="t_data.text"
            >
        </div>
    </div>
</template>

<script>
export default {
    props: ['t_data'],
    data() {
        return {
            value: ''
        }
    },
}
</script>

<style scoped>
    input {
		max-width: 8rem;
	}
</style>