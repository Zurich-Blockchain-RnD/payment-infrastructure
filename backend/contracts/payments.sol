pragma solidity ^0.4.2;

contract Payments {
    function makePayment(address provider) public payable {
        // make payment to the provider
        require(msg.value > 0);
        provider.transfer(msg.value);
    }
}