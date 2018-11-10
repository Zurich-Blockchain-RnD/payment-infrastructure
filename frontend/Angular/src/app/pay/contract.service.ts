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
  private paymentContract;
  constructor() {

    this.web3Provider = new Web3.providers.HttpProvider('http://localhost:8545');
    window.web3 = new Web3(this.web3Provider);
    web3 = window.web3;
    this.paymentContract = new web3.eth.Contract(tokenAbi.abi, '0xb1b8f910c76fdd747dca4ba8dabeee8e7a02b822');

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
  async transferEther(_transferFrom: string, _transferTo: string, _amount: string, _remarks?: string) {
    const res = await this.paymentContract.methods
      .transferFund(_transferTo)
      .send({
        from: _transferFrom,
        value: web3.utils.toWei(_amount, 'ether')
      });
    console.log(res);
  }
}
