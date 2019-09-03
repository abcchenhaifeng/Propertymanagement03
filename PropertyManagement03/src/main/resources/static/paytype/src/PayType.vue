<template>
	<div id="pay-type">
		<list-box></list-box>
	</div>
</template>

<script>
import ListBox from './components/ListBox.vue'

export default {
	components: {
		ListBox
	}
}
</script>

<style lang="scss">
@import './variables.scss';

*, *::before, *::after {
	box-sizing: border-box;
}

#pay-type {
	color: $vue-blue;
}
</style>