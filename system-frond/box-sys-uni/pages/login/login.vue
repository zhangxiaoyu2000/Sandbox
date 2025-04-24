<template>
  <view class="container">
    <view class="form-structor" :class="{ 'slide-up': activeForm === 'login' }">
      <!-- 登录模块 -->
      <view class="signup" :class="{ 'slide-up': activeForm !== 'signup' }">
        <view class="form-title">
          登录
        </view>
        <view class="form-holder">
          <input 
            type="text" 
            class="input" 
            placeholder="用户名" 
            placeholder-class="placeholder"
          />
          <input 
            type="password" 
            class="input" 
            placeholder="密码" 
            placeholder-class="placeholder"
          />
        </view>
        <button class="submit-btn" @tap="handleSignup">登录</button>
      </view>
    </view>
  </view>
</template>

<script>
export default {
  data() {
    return {
      activeForm: 'signup' // 当前激活的表单
    };
  },
  methods: {
    toggleForm() {
      this.activeForm = this.activeForm === 'login' ? 'signup' : 'login';
    },
    handleLogin() {
      // 处理登录逻辑
      uni.showToast({
        title: 'Login clicked',
        icon: 'none'
      });
    },
    handleSignup() {
      // 处理注册逻辑
      uni.showToast({
        title: 'Signup clicked',
        icon: 'none'
      });
    }
  }
};
</script>

<style lang="scss" scoped>
.container {
  flex: 1;
  background-color: #e1e8ee;
  display: flex;
  align-items: center;
  justify-content: center;
  font-family: "Fira Sans", Helvetica, Arial, sans-serif;
}

.form-structor {
  background-color: #222;
  height: 100vh;
  width: 100%;
  position: relative;
  overflow: hidden;

  &::after {
    content: "";
    opacity: 0.8;
    position: absolute;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
    background-repeat: no-repeat;
    background-position: left bottom;
    background-size: 500px;
    background-image: url("@/static/login-bg.png");
  }

  .signup {
    position: absolute;
    top: 30%;
    left: 50%;
	height: 80%;
    transform: translate(-57%, -35%);
    // width: 65%;
    z-index: 5;
    transition: all 0.3s ease;
	display: flex;
	flex-flow: column;
	justify-content: center;
	align-items: center;

    &.slide-up {
      top: 100%;
      transform: translate(-57%, -60%);
      transition: all 0.3s ease;

      .form-holder,
      .submit-btn {
        opacity: 0;
		width: 40px;
        visibility: hidden;
      }

      .form-title {
        // font-size: 3em;
        cursor: pointer;

        .switch-text {
          margin-right: 5px;
          opacity: 1;
          visibility: visible;
          transition: all 0.3s ease;
        }
      }
    }

    .form-title {
      color: #fff;
      font-size: 1.7em;
      text-align: center;
      cursor: pointer;
	  margin-left: 16%;

      .switch-text {
        color: rgba(0, 0, 0, 0.4);
        opacity: 0;
        visibility: hidden;
        transition: all 0.3s ease;
      }
    }

    .form-holder {
      border-radius: 15px;
      // background-color: #fff;
      // overflow: hidden;
      margin-top: 20px;
      opacity: 1;
      visibility: visible;
      transition: all 0.3s ease;

      .input {
        border: 0;
        outline: none;
        box-shadow: none;
        height: 30px;
        line-height: 30px;
        padding: 8px 15px;
		margin-bottom: 20rpx;
        // border-bottom: 1px solid #eee;
		border: 3px solid #eee;
		border-radius: 15px;
        width: 100%;
        font-size: 12px;
      }
    }

    .submit-btn {
      background-color: rgba(0, 0, 0, 0.4);
      color: rgba(255, 255, 255, 0.7);
      border: 0;
      border-radius: 15px;
      display: block;
      margin-left: 10%;
      padding: 15px 45px;
      // width: 100%;
      font-size: 13px;
      font-weight: bold;
      opacity: 1;
      visibility: visible;
      transition: all 0.3s ease;

      &:active {
        background-color: rgba(0, 0, 0, 0.8);
      }
    }
  }

  .login {
    position: absolute;
    top: 0%;
    left: 0;
    right: 0;
    bottom: 0;
	background-repeat: no-repeat;
	background-position: left bottom;
	background-size: 500px;
	background-image: url(@/static/login-bg.png);
    // background-color: #fff;
    z-index: 5;
    transition: all 0.3s ease;
	border-top-right-radius: 50rpx;
	border-top-left-radius: 50rpx;
	overflow: hidden;

    &::before {
      content: "";
      position: absolute;
      left: 50%;
      top: -20px;
      transform: translate(-50%, 0);
      // background-color: #fff;
      width: 200%;
      height: 50rpx;
      // border-radius: 25rpx;
      z-index: 4;
      transition: all 0.3s ease;
    }

    &.slide-up {
      top: 90%;
      transition: all 0.3s ease;

      .center {
        top: 10%;
        transform: translate(-50%, 0%);
      }

      .form-holder,
      .submit-btn {
        opacity: 0;
        visibility: hidden;
      }

      .form-title {
        font-size: 1em;
        cursor: pointer;

        .switch-text {
          margin-right: 5px;
          opacity: 1;
          visibility: visible;
          transition: all 0.3s ease;
        }
      }
    }

    .center {
      position: absolute;
      top: calc(50% - 10%);
      left: 50%;
      transform: translate(-50%, -50%);
      width: 65%;
      z-index: 5;
      transition: all 0.3s ease;

      .form-title {
        color: #000;
        font-size: 1.7em;
        text-align: center;
        cursor: pointer;

        .switch-text {
          color: rgba(0, 0, 0, 0.4);
          opacity: 0;
          visibility: hidden;
          transition: all 0.3s ease;
        }
      }

      .form-holder {
        border-radius: 15px;
        background-color: #fff;
        border: 1px solid #eee;
        overflow: hidden;
        margin-top: 50px;
        opacity: 1;
        visibility: visible;
        transition: all 0.3s ease;

        .input {
          border: 0;
          outline: none;
          box-shadow: none;
          height: 30px;
          line-height: 30px;
          padding: 8px 15px;
          border-bottom: 1px solid #eee;
          width: 100%;
          font-size: 12px;

          &:last-child {
            border-bottom: 0;
          }
        }
      }

      .login-btn {
        background-color: #6b92a4;
        color: rgba(255, 255, 255, 0.7);

        &:active {
          background-color: rgba(0, 0, 0, 0.8);
        }
      }
    }
  }
}

.placeholder {
  color: rgba(0, 0, 0, 0.4) !important;
}

/* 重置小程序按钮样式 */
button {
  background-color: transparent;
  padding: 0;
  margin: 0;
  line-height: inherit;
  &::after {
    border: none;
  }
}
</style>