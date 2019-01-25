<template>
  <div>
    <h4>Driver</h4>
    <div>
      <label>Name: </label> {{driver.name}}
    </div>
    <div>
      <label>Balance: </label> {{driver.balance}}
    </div>
  </div>
  
</template>

<script>
import http from "../http-common";

export default {
  name: "driver",
  props: ["driver"],
  methods: {
  }
};
</script>