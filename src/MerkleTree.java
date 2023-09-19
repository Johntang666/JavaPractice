import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class MerkleTree {
    private List<String> data;
    private List<String> hashList;

    public MerkleTree(List<String> data) {
        this.data = data;
        this.hashList = new ArrayList<>();
    }

    // 计算哈希值
    public static String sha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    // 构建哈希树并返回根哈希值
    public String buildTreeAndGetRootHash() {
        // 计算叶子节点的哈希值
        for (String datum : data) {
            hashList.add(sha256(datum));
        }

        // 计算非叶子节点的哈希值
        while (hashList.size() > 1) {
            List<String> tempHashList = new ArrayList<>();
            for (int i = 0; i < hashList.size(); i += 2) {
                if (i + 1 < hashList.size()) {
                    tempHashList.add(sha256(hashList.get(i) + hashList.get(i + 1)));
                } else {
                    tempHashList.add(sha256(hashList.get(i) + hashList.get(i)));
                }
            }
            hashList = tempHashList;
        }

        // 返回根哈希值
        return hashList.get(0);
    }

    public static void main(String[] args) {
        List<String> data = new ArrayList<>();
        data.add("Block1");
        data.add("Block2");
        data.add("Block3");
        data.add("Block4");

        MerkleTree merkleTree = new MerkleTree(data);
        String rootHash = merkleTree.buildTreeAndGetRootHash();
        System.out.println("Merkle Tree Root Hash: " + rootHash);
    }
}
