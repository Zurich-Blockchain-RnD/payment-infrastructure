import { Injectable } from '@angular/core';
import * as Web3 from 'web3';

const tokenAbi = require('../../smart-contracts/build/contracts/Payment.json');


declare let require: any;
declare let window: any;
declare let web3: any;
@Injectable({
  providedIn: 'root'
})
export class ContractService {
  private web3Provider: null;
  private contracts: {};
  constructor() {
    // if (typeof window.web3 !== 'undefined') {
    //   this.web3Provider = window.web3.currentProvider;
    // } else {
    //   this.web3Provider = new Web3.providers.HttpProvider('http://localhost:8545');
    // }
    this.web3Provider = new Web3.providers.HttpProvider('http://localhost:8545');
    window.web3 = new Web3(this.web3Provider);
    web3 = window.web3;
  }
  getAccountInfo() {
    return new Promise((resolve, reject) => {
      web3.eth.getCoinbase(function (err, account) {
        if (err === null) {
          web3.eth.getBalance(account, function (err, balance) {
            if (err === null) {
              return resolve({ fromAccount: account, balance: web3.fromWei(balance, 'ether') });
            } else {
              return reject('error!');
            }
          });
        }
      });
    });

  }
  transferEther(_transferFrom, _transferTo, _amount, _remarks?) {
    const that = this;
    return new Promise((resolve, reject) => {
      const paymentContract = web3.eth.contract(tokenAbi.abi);
      paymentContract.setProvider(this.web3Provider);
      paymentContract.deployed().then(function (instance) {
        return instance.transferFund(
          _transferTo,
          {
            from: _transferFrom,
            value: web3.toWei(_amount, 'ether')
          });
      }).then(function (status) {
        if (status) {
          return resolve({ status: true });
        }
      }).catch(function (error) {
        console.log(error);
        return reject('Error in transferEther service call');
      });
    });
  }
}
