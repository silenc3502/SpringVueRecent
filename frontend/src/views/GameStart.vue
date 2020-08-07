<template>
  <div class="webgl">
    <vgl-renderer class="getting-started">
      <vgl-sphere-geometry name="sphere"></vgl-sphere-geometry>
      <vgl-scene>
        <!-- Re-rendering will be triggered when zCoordinate changes. -->
        <vgl-mesh :position="`0 0 ${zCoordinate}`" geometry="sphere"></vgl-mesh>
      </vgl-scene>
      <vgl-perspective-camera orbit-position="10 0 0">
      </vgl-perspective-camera>
    </vgl-renderer>
    <!-- User can handles zCoordinate via this range input. -->
    <input type="range" v-model="zCoordinate" min="-5" max="5">
  </div>
</template>

<script>

export default {
  name: 'GameStart',
  data () {
    return {
      zCoordinate: 0
    }
  }
}

</script>

<style>
.getting-started {
  width: 640px;
  height: 500px;
}
</style>
