package com.zurichdev.payback.ethereum;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.5.0.
 */
public class Dentist extends Contract {
    private static final String BINARY = "{\r\n"
            + "\t\"linkReferences\": {},\r\n"
            + "\t\"object\": \"608060405234801561001057600080fd5b5061031d806100206000396000f300608060405260043610610062576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680634c73890914610067578063883d0cae14610092578063c290d691146100a9578063e4d7a3d4146100c9575b600080fd5b34801561007357600080fd5b5061007c610135565b6040518082815260200191505060405180910390f35b34801561009e57600080fd5b506100a7610154565b005b6100c7600480360381019080803590602001909291905050506101bc565b005b3480156100d557600080fd5b506100de610263565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b83811015610121578082015181840152602081019050610106565b505050509050019250505060405180910390f35b60003073ffffffffffffffffffffffffffffffffffffffff1631905090565b60003390806001815401808255809150509060018203906000526020600020016000909192909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b66b1a2bc2ec5000034111515610260576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260218152602001807f596f75206e65656420746f20706179206174206c6561737420302e303520455481526020017f480000000000000000000000000000000000000000000000000000000000000081525060400191505060405180910390fd5b50565b606060008054806020026020016040519081016040528092919081815260200182805480156102e757602002820191906000526020600020905b8160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001906001019080831161029d575b50505050509050905600a165627a7a72305820c0930e86f7ee72f717cc8f12692f670dfb334bfbdcaa2dd2ac97c10e9591fc340029\",\r\n"
            + "\t\"opcodes\": \"PUSH1 0x80 PUSH1 0x40 MSTORE CALLVALUE DUP1 ISZERO PUSH2 0x10 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH2 0x31D DUP1 PUSH2 0x20 PUSH1 0x0 CODECOPY PUSH1 0x0 RETURN STOP PUSH1 0x80 PUSH1 0x40 MSTORE PUSH1 0x4 CALLDATASIZE LT PUSH2 0x62 JUMPI PUSH1 0x0 CALLDATALOAD PUSH29 0x100000000000000000000000000000000000000000000000000000000 SWAP1 DIV PUSH4 0xFFFFFFFF AND DUP1 PUSH4 0x4C738909 EQ PUSH2 0x67 JUMPI DUP1 PUSH4 0x883D0CAE EQ PUSH2 0x92 JUMPI DUP1 PUSH4 0xC290D691 EQ PUSH2 0xA9 JUMPI DUP1 PUSH4 0xE4D7A3D4 EQ PUSH2 0xC9 JUMPI JUMPDEST PUSH1 0x0 DUP1 REVERT JUMPDEST CALLVALUE DUP1 ISZERO PUSH2 0x73 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH2 0x7C PUSH2 0x135 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 DUP3 DUP2 MSTORE PUSH1 0x20 ADD SWAP2 POP POP PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST CALLVALUE DUP1 ISZERO PUSH2 0x9E JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH2 0xA7 PUSH2 0x154 JUMP JUMPDEST STOP JUMPDEST PUSH2 0xC7 PUSH1 0x4 DUP1 CALLDATASIZE SUB DUP2 ADD SWAP1 DUP1 DUP1 CALLDATALOAD SWAP1 PUSH1 0x20 ADD SWAP1 SWAP3 SWAP2 SWAP1 POP POP POP PUSH2 0x1BC JUMP JUMPDEST STOP JUMPDEST CALLVALUE DUP1 ISZERO PUSH2 0xD5 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH2 0xDE PUSH2 0x263 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 DUP1 PUSH1 0x20 ADD DUP3 DUP2 SUB DUP3 MSTORE DUP4 DUP2 DUP2 MLOAD DUP2 MSTORE PUSH1 0x20 ADD SWAP2 POP DUP1 MLOAD SWAP1 PUSH1 0x20 ADD SWAP1 PUSH1 0x20 MUL DUP1 DUP4 DUP4 PUSH1 0x0 JUMPDEST DUP4 DUP2 LT ISZERO PUSH2 0x121 JUMPI DUP1 DUP3 ADD MLOAD DUP2 DUP5 ADD MSTORE PUSH1 0x20 DUP2 ADD SWAP1 POP PUSH2 0x106 JUMP JUMPDEST POP POP POP POP SWAP1 POP ADD SWAP3 POP POP POP PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST PUSH1 0x0 ADDRESS PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND BALANCE SWAP1 POP SWAP1 JUMP JUMPDEST PUSH1 0x0 CALLER SWAP1 DUP1 PUSH1 0x1 DUP2 SLOAD ADD DUP1 DUP3 SSTORE DUP1 SWAP2 POP POP SWAP1 PUSH1 0x1 DUP3 SUB SWAP1 PUSH1 0x0 MSTORE PUSH1 0x20 PUSH1 0x0 KECCAK256 ADD PUSH1 0x0 SWAP1 SWAP2 SWAP3 SWAP1 SWAP2 SWAP1 SWAP2 PUSH2 0x100 EXP DUP2 SLOAD DUP2 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF MUL NOT AND SWAP1 DUP4 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND MUL OR SWAP1 SSTORE POP POP JUMP JUMPDEST PUSH7 0xB1A2BC2EC50000 CALLVALUE GT ISZERO ISZERO PUSH2 0x260 JUMPI PUSH1 0x40 MLOAD PUSH32 0x8C379A000000000000000000000000000000000000000000000000000000000 DUP2 MSTORE PUSH1 0x4 ADD DUP1 DUP1 PUSH1 0x20 ADD DUP3 DUP2 SUB DUP3 MSTORE PUSH1 0x21 DUP2 MSTORE PUSH1 0x20 ADD DUP1 PUSH32 0x596F75206E65656420746F20706179206174206C6561737420302E3035204554 DUP2 MSTORE PUSH1 0x20 ADD PUSH32 0x4800000000000000000000000000000000000000000000000000000000000000 DUP2 MSTORE POP PUSH1 0x40 ADD SWAP2 POP POP PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 REVERT JUMPDEST POP JUMP JUMPDEST PUSH1 0x60 PUSH1 0x0 DUP1 SLOAD DUP1 PUSH1 0x20 MUL PUSH1 0x20 ADD PUSH1 0x40 MLOAD SWAP1 DUP2 ADD PUSH1 0x40 MSTORE DUP1 SWAP3 SWAP2 SWAP1 DUP2 DUP2 MSTORE PUSH1 0x20 ADD DUP3 DUP1 SLOAD DUP1 ISZERO PUSH2 0x2E7 JUMPI PUSH1 0x20 MUL DUP3 ADD SWAP2 SWAP1 PUSH1 0x0 MSTORE PUSH1 0x20 PUSH1 0x0 KECCAK256 SWAP1 JUMPDEST DUP2 PUSH1 0x0 SWAP1 SLOAD SWAP1 PUSH2 0x100 EXP SWAP1 DIV PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP2 MSTORE PUSH1 0x20 ADD SWAP1 PUSH1 0x1 ADD SWAP1 DUP1 DUP4 GT PUSH2 0x29D JUMPI JUMPDEST POP POP POP POP POP SWAP1 POP SWAP1 JUMP STOP LOG1 PUSH6 0x627A7A723058 KECCAK256 0xc0 SWAP4 0xe DUP7 0xf7 0xee PUSH19 0xF717CC8F12692F670DFB334BFBDCAA2DD2AC97 0xc1 0xe SWAP6 SWAP2 0xfc CALLVALUE STOP 0x29 \",\r\n"
            + "\t\"sourceMap\": \"28:484:0:-;;;;8:9:-1;5:2;;;30:1;27;20:12;5:2;28:484:0;;;;;;;\"\r\n"
            + "}";

    public static final String FUNC_GETMYBALANCE = "getMyBalance";

    public static final String FUNC_NEWCLIENT = "newClient";

    public static final String FUNC_PAY = "pay";

    public static final String FUNC_GETALLCLIENTS = "getAllClients";

    protected Dentist(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Dentist(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<BigInteger> getMyBalance() {
        final Function function = new Function(FUNC_GETMYBALANCE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> newClient() {
        final Function function = new Function(
                FUNC_NEWCLIENT, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> pay(BigInteger amount, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_PAY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<List> getAllClients() {
        final Function function = new Function(FUNC_GETALLCLIENTS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        return new RemoteCall<List>(
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public static RemoteCall<Dentist> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Dentist.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Dentist> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Dentist.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static Dentist load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Dentist(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Dentist load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Dentist(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
