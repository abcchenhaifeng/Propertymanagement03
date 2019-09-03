<template>
    <div id="search-button" class="col-auto my-1">
        <button type="button" class="btn btn-outline-secondary" @click="$emit('reloadList')">检索</button>&nbsp;
        <button type="reset" class="btn btn-outline-secondary" @click="$emit('reset')">重置</button>
    </div>
</template>

<script>
export default {
    
}
</script>

<style scoped>

</style>