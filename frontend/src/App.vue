<script setup>
import { ref, watch, onMounted, provide, inject } from 'vue';
import { RouterView } from 'vue-router';
import axios from 'axios';
import { useCookies } from 'vue-cookies';

import { API_URL, getAuthHeaders } from '../config.js';

const $cookies = inject('$cookies');

const savedUser = $cookies.get('user');
const user = ref(savedUser || null);

const token = ref($cookies.get('token'));

watch([token, user], () => {
  if (token.value && !user.value) {
    // token verification
    axios.get(`${API_URL}/user`, {
      headers: {
        'Authorization': `Bearer ${token.value}`
      }
    })
    .then(response => {
      if (response.data.id) {
        user.value = response.data;
        $cookies.set('user', response.data);
      } else {
        $cookies.remove('token');
        $cookies.remove('user');
        token.value = null;
      }
    })
    .catch(() => {
      $cookies.remove('token');
      $cookies.remove('user');
      token.value = null;
    });
  }
}, { immediate: true });

const handleLogin = (newToken, userData) => {
  $cookies.set('token', newToken);
  $cookies.set('user', userData);
  token.value = newToken;
  user.value = userData;
};

const handleLogout = () => {
  $cookies.remove('token');
  $cookies.remove('user');
  token.value = null;
  user.value = null;
};

provide('user', user);
provide('token', token);
provide('handleLogin', handleLogin);
provide('handleLogout', handleLogout);
provide('$cookies', $cookies);

</script>

<template>
  <router-view />
</template>

<style>
:root {
/* Hub Color Palette */
  --buzzlite: #f1e19f;
  --buzzGray: #373737;
  /* Eggplant Color Palette */
  --green: #349948;
  --greenlite: #c2e0c8;
  --purple: #43217e;
  --purplelite: #ebd6e7;
  --blue: #345299;
  --orange: #997a34;
}
html {
  height: 100%;
}
body{
  margin:0;
  height:100%;
}
#app{
  height:100%;
}
</style>
