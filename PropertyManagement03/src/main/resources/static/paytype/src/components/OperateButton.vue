<template>
    <div id="operate-button" class="col-auto text-right" style="margin: 0 0 0 auto;">
        <a 
            v-for="data in datas"
            :key="data.method"
            :href="data.url" 
            :method="data.method" 
            class="btn btn-primary list-link" 
            :title="data.text"
            @click.prevent="$emit('operate', data.method)"
        >{{data.text}}</a>
    </div>
</template>

<script>
export default {
    props: ['datas'],
}
</script>

<style scoped>
    a {
        margin: 0 5px;
    }
</style>